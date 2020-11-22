package com.skillq.main.service;

import com.skillq.main.model.entity.Question;
import com.skillq.main.model.entity.QuestionAnswer;
import com.skillq.main.model.response.QuestionResponse;
import com.skillq.main.model.response.QuestionResponseList;
import com.skillq.main.repository.QuestionAnswerRepository;
import com.skillq.main.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetQuestionsByChapterIdService {

    private QuestionRepository questionRepository;
    private QuestionAnswerRepository questionAnswerRepository;

    public GetQuestionsByChapterIdService(QuestionRepository questionRepository, QuestionAnswerRepository questionAnswerRepository) {
        this.questionRepository = questionRepository;
        this.questionAnswerRepository = questionAnswerRepository;
    }

    // 1) Retrieve all questions that corresponds to the chapter Id
    // 2) Get a list of all the questionId to be used to query the QuestionAnswer DB
    // 3) Query to QuestionAnswer DB
    // 4) For each question in the list, retrieve the corresponding answers then create the QuestionResponse object
    public List<QuestionResponse> execute(String chapterId){
        List<QuestionResponse> questionResponseList = new ArrayList<>();

        // 1
        List<Question> questionList = questionRepository.findByChapterId(chapterId);

        // 2
        List<String> questionIdList = questionList.stream().map(Question::getQuestionId).collect(Collectors.toList());

        // 3
        List<QuestionAnswer> questionAnswerList = questionAnswerRepository.findByQuestionIdIn(questionIdList);

        // 4
        for(Question eachQ : questionList){

            List<String> answers = questionAnswerList.stream().
                    filter(questionAnswer -> questionAnswer.getQuestionId().equalsIgnoreCase(eachQ.getQuestionId())) // get list of QuestionAnswer that has matching questionId
                    .map(QuestionAnswer::getAnswer) // get only the answers from this filtered questionAnswerList
                    .collect(Collectors.toList());

            questionResponseList.add(QuestionResponse.builder()
                    .answers(answers)
                    .question(eachQ)
                    .build());
        }

        return questionResponseList;
    }
}

package com.skillq.main.controller;

import com.skillq.main.model.response.QuestionResponse;
import com.skillq.main.repository.QuestionRepository;
import com.skillq.main.service.GetQuestionsByChapterIdService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/questions")
@Log4j2
public class QuestionController {

    private QuestionRepository questionRepository;
    private GetQuestionsByChapterIdService getQuestionsByChapterIdService;

    public QuestionController(QuestionRepository questionRepository,
                              GetQuestionsByChapterIdService getQuestionsByChapterIdService) {
        this.questionRepository = questionRepository;
        this.getQuestionsByChapterIdService = getQuestionsByChapterIdService;
    }

    @GetMapping("/")
    public List<QuestionResponse> getQuestionsByChapterId(@RequestParam String chapterId){
        log.debug("Question Request with chapterId: {} is invoked", chapterId);
        return getQuestionsByChapterIdService.execute(chapterId);
    }

}

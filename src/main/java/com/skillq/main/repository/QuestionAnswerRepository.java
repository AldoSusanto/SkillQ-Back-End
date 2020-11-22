package com.skillq.main.repository;

import com.skillq.main.model.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, String> {

    List<QuestionAnswer> findByQuestionIdIn(List<String> questionIdList);
}

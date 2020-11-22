package com.skillq.main.repository;

import com.skillq.main.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, String> {

    List<Question> findByChapterId(String chapterId);
}

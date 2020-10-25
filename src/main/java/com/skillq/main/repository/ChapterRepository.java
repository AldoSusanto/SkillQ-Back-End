package com.skillq.main.repository;

import com.skillq.main.model.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChapterRepository extends JpaRepository<Chapter, String> {

    Optional<Chapter> findByCourseIdAndChapterNumber(String courseId, String chapterNumber);
}

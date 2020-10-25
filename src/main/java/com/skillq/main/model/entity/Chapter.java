package com.skillq.main.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {

    @Id
    private String chapterId;
    private String courseId;
    private String chapterNumber;
    private String title;
    private String type;
    private String videoLink;
    private String quizId;

    @Column(length = 500)
    private String description;
}


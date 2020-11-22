package com.skillq.main.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    private String questionId;
    private String chapterId;
    private String questionType;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String hint1;
    private String hint2;
    private String hint3;
    private String imageLink;
}

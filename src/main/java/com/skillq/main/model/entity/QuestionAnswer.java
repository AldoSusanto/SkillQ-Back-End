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
public class QuestionAnswer {
    //I realize that this DB seems stupid, but this is so that a question can have as many answers as needed.
    //In the future, maybe using ElasticSearch would be a better option

    @Id
    private String questionAnswerId;
    private String questionId;
    private String answer;
}

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
public class Course {

    @Id
    private String courseId;
    private String courseName;

    @Column(length = 500)
    private String descriptionHomepage;

    @Column(length = 500)
    private String descriptionMenubar;
    private String author;
    private Long price;
}

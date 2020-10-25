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
public class UserCourse {

    @Id
    private String userCourseId;
    private String username;
    private String courseId;
    private String currentChapter;

}

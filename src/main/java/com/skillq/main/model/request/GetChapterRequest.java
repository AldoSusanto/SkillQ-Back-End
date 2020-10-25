package com.skillq.main.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class GetChapterRequest {

    @NotBlank(message = "CourseId is mandatory")
    private String courseId;

    @NotBlank(message = "Chapter Number is mandatory")
    private String chapterNumber;
}

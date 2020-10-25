package com.skillq.main.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class GetUserCurrentChapterRequest {

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Course ID is mandatory")
    private String courseId;

}

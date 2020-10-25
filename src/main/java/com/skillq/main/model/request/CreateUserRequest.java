package com.skillq.main.model.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CreateUserRequest {

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Fullname is mandatory")
    private String fullName;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "MobileNumber is mandatory")
    private String mobileNumber;

}

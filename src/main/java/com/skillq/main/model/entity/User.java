package com.skillq.main.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private String cif;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Fullname is mandatory")
    private String fullName;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;
    private String mobileNumber;
    private Timestamp createdTime;
    private Timestamp updatedTime;

}

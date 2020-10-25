package com.skillq.main.service;

import com.skillq.main.model.entity.User;
import com.skillq.main.model.request.CreateUserRequest;
import com.skillq.main.repository.UserRepository;
import com.skillq.main.util.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;

@Service
public class CreateUserService {

    //1 check user with that email or username already exists or not
    //2 (later), encrypt password
    //3 create the user in the repository

    private UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(CreateUserRequest userRequest){

        //1
        if(userNameExists(userRequest)) throw new BusinessException( "00001", "An account with username " + userRequest.getUsername() + " already exists");
        if(emailExists(userRequest)) throw new BusinessException("00002", "An account with email " + userRequest.getEmail() + " already exists");

        //2 todo

        //3
        User newUser = User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .fullName(userRequest.getFullName())
                .mobileNumber(userRequest.getMobileNumber())
                .password(userRequest.getPassword())
                .createdTime(new Timestamp(System.currentTimeMillis()))
                .updatedTime(new Timestamp(System.currentTimeMillis()))
                .build();

        return userRepository.save(newUser);
    }

    private boolean userNameExists(CreateUserRequest userRequest) {
        return userRepository.existsByUsername(userRequest.getUsername());
    }

    private boolean emailExists(CreateUserRequest userRequest) {
        return userRepository.existsByEmail(userRequest.getEmail());
    }

}

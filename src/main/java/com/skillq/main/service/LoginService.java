package com.skillq.main.service;

import com.skillq.main.model.entity.User;
import com.skillq.main.model.request.LoginRequest;
import com.skillq.main.repository.UserRepository;
import com.skillq.main.util.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LoginService {

    //1 retrieve user with that username
    //2 Decrypt the password (later)
    //3 Check whether the inputted password matches the DB password

    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute(LoginRequest loginRequest){

        //1
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(()-> new BusinessException(HttpStatus.NOT_FOUND, "00003", "User with username " + loginRequest.getUsername() + " is not found" ));

        //2 todo

        //3
        return loginRequest.getPassword().equals(user.getPassword());
    }
}

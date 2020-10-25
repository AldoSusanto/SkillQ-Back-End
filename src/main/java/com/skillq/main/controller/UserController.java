package com.skillq.main.controller;

import com.skillq.main.model.request.LoginRequest;
import com.skillq.main.service.CreateUserService;
import com.skillq.main.model.entity.User;
import com.skillq.main.model.request.CreateUserRequest;
import com.skillq.main.repository.UserRepository;
import com.skillq.main.service.LoginService;
import com.skillq.main.util.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private UserRepository userRepository;
    private CreateUserService createUserService;
    private LoginService loginService;

    public UserController(UserRepository userRepository, CreateUserService createUserService, LoginService loginService) {
        this.userRepository = userRepository;
        this.createUserService = createUserService;
        this.loginService = loginService;
    }

    @GetMapping("/")
    private User getUserById(@RequestParam String userId){
        return userRepository.findById(userId)
                .orElseThrow( () ->
                new BusinessException(HttpStatus.NOT_FOUND, "00003", "UserId with ID " + userId + " not found"));
    }

    @GetMapping("/{username}")
    private User getUserByUsername(@RequestParam String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new BusinessException(HttpStatus.NOT_FOUND, "00003", "User with Username " + username + " doesn't exist"));
    }

    @PostMapping("/")
    private User createNewUser(@Valid @RequestBody CreateUserRequest userRequest){
        return createUserService.execute(userRequest);
    }

    @PostMapping("/login")
    private boolean checkPassword(@Valid @RequestBody LoginRequest loginRequest){
        return loginService.execute(loginRequest);
    }

}

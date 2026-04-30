package com.teamtask.teamtask.controller;

import com.teamtask.teamtask.entity.User;
import com.teamtask.teamtask.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    // SIGNUP
    @PostMapping("/signup")
    public User signup(
            @RequestBody User user
    ) {

        user.setPassword(
                encoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }

    // LOGIN
    @PostMapping("/login")
    public String login(
            @RequestBody User loginUser
    ) {

        User user = userRepository
                .findByEmail(loginUser.getEmail())
                .orElse(null);

        if (
                user != null
                        &&
                        encoder.matches(
                                loginUser.getPassword(),
                                user.getPassword()
                        )
        ) {

            return "Login Successful";
        }

        return "Invalid Email or Password";
    }
}

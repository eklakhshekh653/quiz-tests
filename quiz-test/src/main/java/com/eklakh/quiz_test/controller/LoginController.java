package com.eklakh.quiz_test.controller;

import com.eklakh.quiz_test.entity.QuizQuestion;
import com.eklakh.quiz_test.entity.User;
import com.eklakh.quiz_test.service.QuestionService;
import com.eklakh.quiz_test.service.UserService;
import com.eklakh.quiz_test.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserServices userServices;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (userServices.login(username, password)) {
            return "Login successful!";
        } else {
            return "Invalid username or password.";
        }
    }

    @GetMapping("/questions")
    public List<QuizQuestion> getQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public QuizQuestion saveQuestion(@RequestBody QuizQuestion question) {
        return questionService.saveQuestion(question);
    }

    @PostMapping("/reg")
    public User registration(@RequestBody User user) {
        return userService.userSave(user);
    }
    @GetMapping("/Sdata")
    public List<User> gtAllData(){
        return  userService.getAllData();
    }
}
package com.eklakh.quiz_test.service;

import com.eklakh.quiz_test.entity.User;
import com.eklakh.quiz_test.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    public boolean login(String username, String password) {
        Optional<User> user = findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
}
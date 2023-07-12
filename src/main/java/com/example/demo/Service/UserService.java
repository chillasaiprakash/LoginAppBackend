package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getRegisterUser() {
        // Additional validation and logic can be added here before saving the user

        return userRepository.findAll();
    }



    public User registerUser(User user) {
        // Additional validation and logic can be added here before saving the user

        return userRepository.save(user);
    }
}
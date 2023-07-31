package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    Connection connection;

    @Autowired
    UserRepository userRepository;
     int flag=0;

    public List<User> getRegisterUser() {
        // Additional validation and logic can be added here before saving the user

        return userRepository.findAll();
    }



    public User registerUser(User user) {
        // Additional validation and logic can be added here before saving the user

        return userRepository.save(user);
    }
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);

    }

}
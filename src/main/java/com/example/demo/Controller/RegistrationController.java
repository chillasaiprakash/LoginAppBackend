package com.example.demo.Controller;
import com.example.demo.Service.UserService;
import com.example.demo.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200/")
    public class RegistrationController {
        @Autowired
        UserService userService;


        @GetMapping("/getAllUsers")
        public List<User> getRegisterUser()
        {
            return userService.getRegisterUser();
        }

        @PostMapping

        public User registerUser(@RequestBody User user) {

            return userService.registerUser(user);
        }
    }


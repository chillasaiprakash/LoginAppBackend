package com.example.demo.Controller;
import com.example.demo.Service.UserService;
import com.example.demo.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
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

        @PostMapping("/register")

        public User registerUser(@RequestBody User user) {

            return userService.registerUser(user);
        }
    @GetMapping("login/{username}/{password}")
    public int UserLogin(@PathVariable("username") String username1, @PathVariable ("password") String password1) {

        int flag = userService.loginValidation(username1, password1);
        if (flag == 0) {
            return 0;

        }
        return flag;
    }
    /*@GetMapping("/register")

    public List<User> getRegisterUser() {

        return userService.registerUser();
    }*/


    }


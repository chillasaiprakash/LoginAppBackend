package com.example.demo.Controller;
import com.example.demo.Service.UserService;
import com.example.demo.dao.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200/")
    public class RegistrationController {
    Logger logger= LoggerFactory.getLogger(RegistrationController.class);
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

    @PostMapping("/login")
    public User login(@RequestBody User user ) throws Exception{
       String tempUser=user.getUsername();
       String tempPassword=user.getPassword();
       User userObj=null;
        if(tempUser!=null&& tempPassword!=null) {
            userObj = userService.login(tempUser, tempPassword);
        }
        if(userObj==null) {
            logger.info("Bad credentials");
        }
        return userObj;
    }



    /*@GetMapping("/register")

    public List<User> getRegisterUser() {

        return userService.registerUser();
    }*/


    }


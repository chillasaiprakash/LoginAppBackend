package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.dao.User;
import com.example.demo.dbutil.DBUtil;
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
    public void userService() throws SQLException{
        connection = DBUtil.getConnection();
    }
    public int loginValidation(String username,String password){
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT  * FROM USER WHERE username='"+username+"'");
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                    if(rs.getString(8).equals(username)&& rs.getString(7).equals(password))
                    {
                        flag=1;
                    }
                    else {
                        System.out.println("Invalid user name /password");
                    }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
package com.security.SpringSecurity.Controller;

import com.security.SpringSecurity.Service.UserServiceimp;
import com.security.SpringSecurity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class UserController {

    @Autowired
    private UserServiceimp userServiceimp;

    @PostMapping
    public Users add(@RequestBody Users user){
        return userServiceimp.adduser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody Users users){
        System.out.println(users);
        return userServiceimp.verify(users);
    }

}

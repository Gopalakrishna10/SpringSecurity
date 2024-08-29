package com.security.SpringSecurity.Service;

import com.security.SpringSecurity.Repo.UsersRepo;
import com.security.SpringSecurity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimp {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private JwtService jwtService;
    @Autowired
    AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();



    public Users adduser(Users users){
        users.setPassword(encoder.encode(users.getPassword()));
        usersRepo.save(users);
        return users;
    }

    public String verify(Users users) {
        Authentication authentication = authManager.
                authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(),users.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(users.getUsername());

        return "Fail";
    }
}

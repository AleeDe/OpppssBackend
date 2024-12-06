package com.aleedev.SecuityCheck.Service;

import com.aleedev.SecuityCheck.Model.Users;
import com.aleedev.SecuityCheck.Repsoritory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserServices {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;
    @Autowired
    UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users saveUser(Users users){
        users.setPassword(encoder.encode(users.getPassword()));
        return userRepository.save(users);
    }
    public ArrayList<Users> getAllUser(){
        return (ArrayList<Users>) userRepository.findAll();
    }

    public String verify(Users users) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getName(),users.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(users.getName());
        else return "Fail";
    }
}

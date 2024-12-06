package com.aleedev.SecuityCheck.Service;

import com.aleedev.SecuityCheck.Model.UserPrincipal;
import com.aleedev.SecuityCheck.Model.Users;
import com.aleedev.SecuityCheck.Repsoritory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByName(username);
        if (users ==null){
            System.out.println("User don't exist");
            throw new UsernameNotFoundException("User don't exist");
        }
        return new UserPrincipal(users);
    }
}

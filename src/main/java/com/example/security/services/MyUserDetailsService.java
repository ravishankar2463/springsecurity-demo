package com.example.security.services;

import com.example.security.models.MyUserDetails;
import com.example.security.models.User;
import com.example.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findById(username);

        if(userOptional.isPresent()){
            return new MyUserDetails(userOptional.get());
        }else {
            throw new UsernameNotFoundException("No user found in database with username : "+username);
        }
    }


}

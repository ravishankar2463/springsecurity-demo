package com.example.security.services;

import com.example.security.models.Authority;
import com.example.security.models.MyUserDetails;
import com.example.security.models.User;
import com.example.security.repositories.AuthorityRepository;
import com.example.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findUserByUsername(username);

        Optional<List<Authority>> authorityListOptional = authorityRepository.findAuthorityByUsername(username);

        if(userOptional.isPresent()){
            List<Authority> authorityList = new ArrayList<>();

            authorityListOptional.ifPresent((authorities) -> authorityList.addAll(authorities));

            return new MyUserDetails(userOptional.get(),authorityList);
        }else {
            throw new UsernameNotFoundException("No user found in database with username : "+username);
        }
    }


}

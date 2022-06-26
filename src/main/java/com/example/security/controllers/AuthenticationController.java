package com.example.security.controllers;

import com.example.security.jwt.exceptions.InvalidUsernameOrPasswordException;
import com.example.security.jwt.models.AuthenticationRequest;
import com.example.security.jwt.models.AuthenticationResponse;
import com.example.security.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new InvalidUsernameOrPasswordException();
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        return new ResponseEntity<>(new AuthenticationResponse(JwtUtil.generateToken(userDetails)), HttpStatus.OK);
    }

}

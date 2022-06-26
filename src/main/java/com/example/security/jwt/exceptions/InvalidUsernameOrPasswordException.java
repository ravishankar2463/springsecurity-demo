package com.example.security.jwt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED,reason = "Invalid Username Or Password")
public class InvalidUsernameOrPasswordException extends Exception{
    public InvalidUsernameOrPasswordException() {
    }
}

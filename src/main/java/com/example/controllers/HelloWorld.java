package com.example.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Value("${message.welcome}")
    private String welcomeMessage;

    @GetMapping("/welcome")
    public ResponseEntity<String> showWelcomeMessage(){
        return ResponseEntity.ok(welcomeMessage);
    }
}

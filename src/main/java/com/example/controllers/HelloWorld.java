package com.example.controllers;

import com.example.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Value("${message.welcome}")
    private String welcomeMessage;

    @Autowired
    private Config config;

    @GetMapping("/welcome")
    public ResponseEntity<String> showWelcomeMessage(){
        return ResponseEntity.ok(welcomeMessage +" -- " + config.getWelcome());
    }
}

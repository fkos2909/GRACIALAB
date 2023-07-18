package dev.gracialab.glab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/message")
public class MessageController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
    
}

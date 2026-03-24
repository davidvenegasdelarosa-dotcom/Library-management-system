package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


public class HolaMundoController {

    @GetMapping("/saludo")
    public String decirHola() {
        return "me cago en los muertos de spring-boot";
    }
}
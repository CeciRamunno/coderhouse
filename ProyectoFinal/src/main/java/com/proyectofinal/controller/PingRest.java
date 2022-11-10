package com.proyectofinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingRest
{
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}

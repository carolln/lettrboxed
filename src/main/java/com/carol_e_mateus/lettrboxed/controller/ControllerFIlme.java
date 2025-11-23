package com.carol_e_mateus.lettrboxed.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerFIlme {
    @GetMapping("/")
    public String funcao () {
        return "isso eh temporario!";
    }
}

package com.carol_e_mateus.lettrboxed.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUser {
    @GetMapping("/easteregg")
    public String funcao () {
        return "congrats! voce encontrou um easter egg!";
    }
}

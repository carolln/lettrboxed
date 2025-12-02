package com.carol_e_mateus.lettrboxed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carol_e_mateus.lettrboxed.model.*;
import com.carol_e_mateus.lettrboxed.service.*;
import java.util.*;

@RestController
@RequestMapping("/users")
public class ControllerUser {

    @Autowired
    private ServiceUser serviceUser;

    @GetMapping
    public List<User> getAllUsers() {
        return serviceUser.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return serviceUser.getUser(id);
    }

    @GetMapping("/easteregg")
    public String funcao () {
        return "congrats! voce encontrou um easter egg!";
    }
}

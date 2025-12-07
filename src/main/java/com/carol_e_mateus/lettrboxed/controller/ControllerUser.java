package com.carol_e_mateus.lettrboxed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carol_e_mateus.lettrboxed.dto.UserDTO;
import com.carol_e_mateus.lettrboxed.model.*;
import com.carol_e_mateus.lettrboxed.service.*;
import java.util.*;

@RestController
@RequestMapping("/users")
public class ControllerUser {

    @Autowired
    private ServiceUser serviceUser;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return serviceUser.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return serviceUser.getUser(id);
    }

    @GetMapping("/easteregg")
    public String funcao () {
        return "congrats! voce encontrou um easter egg!";
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody User u) {
        return serviceUser.createUser(u);
    }

    @PutMapping("/put")
    public UserDTO updateUser(@RequestBody User u) {
        return serviceUser.updateUser(u);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean deletou = serviceUser.deleteUser(id);

        if (!deletou) {
            return ResponseEntity.notFound().build(); // nao achou e retorna o erro 404
        }

        return ResponseEntity.noContent().build(); // deletou ai retorna um corpo vazio
    }
}

package com.carol_e_mateus.lettrboxed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carol_e_mateus.lettrboxed.model.Filme;
import com.carol_e_mateus.lettrboxed.service.ServiceFilme;

@RestController
@RequestMapping("/filmes")
public class ControllerFIlme {
	
	@Autowired
	private ServiceFilme serviceFilme;
	
    @GetMapping
    public List<Filme> getAllFilmes () {
        return serviceFilme.getAllFilmes();
    }

    @GetMapping("/{id}")
    public Filme getFilme(@PathVariable Long id) {
        return serviceFilme.getFilme(id);
    }

}

package com.carol_e_mateus.lettrboxed.controller;

import java.util.List;

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

    @PostMapping
    public Filme createFilme(@RequestBody Filme filme){
        return serviceFilme.createFilme(filme);
    }

    @PutMapping("/put")
    public Filme updateFilme(@RequestBody Filme filme) {
        return serviceFilme.updateFilme(filme);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable Long id) {
        boolean deletou = serviceFilme.deleteFilme(id);

        if (!deletou) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtrar/{nota}")
    public List<Filme> filtrarFilmes(@PathVariable double nota) {
        return serviceFilme.filtrarFilmes(nota);
    }

}

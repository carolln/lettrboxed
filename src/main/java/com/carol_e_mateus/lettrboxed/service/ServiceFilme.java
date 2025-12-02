package com.carol_e_mateus.lettrboxed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carol_e_mateus.lettrboxed.model.*;
import com.carol_e_mateus.lettrboxed.repository.RepositoryFilme;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceFilme {
	
	@Autowired
	RepositoryFilme repositoryFilme;
	
    public Filme createFilme(Filme filme){

        // to do
        return filme;
    }

    
    public Filme getFilme(Long id){

        if (repositoryFilme.getFilm(id) != null) {
            return repositoryFilme.getFilm(id);
        }
        return null;
    }

    public List<Filme> getAllFilmes(){
        return repositoryFilme.getAll();
    }

    public void deleteFilme(Long id) {
        // to do
    }

    public double getRatingMedio (Long id) {
        // to do
        return 0.00;
    }
}

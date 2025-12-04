package com.carol_e_mateus.lettrboxed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carol_e_mateus.lettrboxed.model.*;
import com.carol_e_mateus.lettrboxed.repository.RepositoryFilme;
import com.carol_e_mateus.lettrboxed.repository.RepositoryReview;
import com.carol_e_mateus.lettrboxed.repository.RepositoryUser;

import jakarta.annotation.PostConstruct;

import java.util.*;

@Service
public class ServiceFilme {
	
	@Autowired
	RepositoryFilme repositoryFilme;

    @Autowired
    RepositoryUser repositoryUser;

    @Autowired
    RepositoryReview repositoryReview;

    @PostConstruct
	public void initializeFilmes() {
        List<Review> eu2 = repositoryReview.GetAll();

		for (Review u : eu2) { // passar por todos os reviews e adiciona-los aos seus devidos users
            repositoryFilme.AddReviewToFilme(u, u.getIdfilme());
		}
	}
	
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
        int runsum = 0;
        int cont = 0;

        for (Review review : repositoryReview.GetAll()) {
            if (review.getIdfilme() == id) {
                runsum+=review.getNota();
                cont++;
            }
        }

        if (cont == 0) {
            return 0D;
        }

        return runsum / cont;

        
    }
}

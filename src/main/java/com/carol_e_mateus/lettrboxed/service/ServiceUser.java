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
public class ServiceUser {

    @Autowired
	RepositoryFilme repositoryFilme;

    @Autowired
    RepositoryUser repositoryUser;

    @Autowired
    RepositoryReview repositoryReview;

    private Long counter;

    @PostConstruct
    public void inicializarCounter() {
        Long maxid = repositoryUser.getIdmax();
        counter = new Long(maxid + 1);
    }

    @PostConstruct
	public void initializeUsers() {
        List<Review> eu2 = repositoryReview.GetAll();

		for (Review u : eu2) { // passar por todos os reviews e adiciona-los aos seus devidos users
            repositoryUser.AddReviewToUser(u, u.getDono());
		}
	}

    public User createUser(User user) {
        repositoryUser.createUser(user);
        user.setId(counter);
        counter++;
        return user;
    }

    public User getUser(Long id) {

        if (repositoryUser.getUser(id) != null) {
            return repositoryUser.getUser(id);
        }
        return null;
    }

    public User updateUser(User u) {
        return repositoryUser.getUser(u.getId()).updateUser(u);
    }

    public List<User> getAllUsers() {

        List<User> a = new ArrayList<>(repositoryUser.getAll());
        return a;
        
    }

    public boolean deleteUser(Long id) {
        // para cada review na lista de reviews
        // tirar a review da lista de reviews do filme em questao
        // apagar a review em questao

        for (Long review : repositoryUser.getUser(id).getReviews()) {
            //pegar o review na lista de reviews; ver a qual filme se refere; tirar dali
            repositoryFilme.getFilm(repositoryReview.getReview(review).getIdfilme()).deleteReview(review);
            //repositoryFilme.AddReviewToFilme(null, id)
            repositoryReview.deleteReview(review);
        }

        return repositoryUser.deleteUser(id);
    }
}

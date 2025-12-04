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

    @PostConstruct
	public void initializeUsers() {
        List<Review> eu2 = repositoryReview.GetAll();

		for (Review u : eu2) { // passar por todos os reviews e adiciona-los aos seus devidos users
            repositoryUser.AddReviewToUser(u, u.getDono());
		}
	}

    public User createUser(User user) {
        // to do
        return user;
    }

    public User getUser(Long id) {

        if (repositoryUser.getUser(id) != null) {
            return repositoryUser.getUser(id);
        }
        return null;
    }

    public List<User> getAllUsers() {

        List<User> a = new ArrayList<>(repositoryUser.getAll());
        return a;
        
    }
}

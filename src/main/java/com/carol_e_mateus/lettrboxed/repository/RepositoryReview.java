package com.carol_e_mateus.lettrboxed.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.carol_e_mateus.lettrboxed.model.Review;

@Repository
public class RepositoryReview {
	
	private HashMap <Long, Review> reviews = new HashMap<>();

}

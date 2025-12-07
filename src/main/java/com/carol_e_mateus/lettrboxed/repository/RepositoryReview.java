package com.carol_e_mateus.lettrboxed.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.carol_e_mateus.lettrboxed.model.Filme;
import com.carol_e_mateus.lettrboxed.model.Review;

@Repository
public class RepositoryReview {
	
	private HashMap <Long, Review> reviews = new HashMap<>();

	private Long maxId;

	public Long getMaxId() {
		return maxId;
	}

	public void setMaxId(Long l) {
		this.maxId = l;
	}

	public RepositoryReview(){

		Long id1 = 1L;

		Review r1 = new Review(1L, 3L, "boe coitado do miles", 9);
		r1.setId(id1);
		reviews.put(id1++, r1);

		Review r2 = new Review(2L, 1L, "loucura essa tal da gravidade neh", 5);
		r2.setId(id1);
		reviews.put(id1++, r2);

		Review r3 = new Review(4L, 3L, "como pode nos humanos", 6);
		r3.setId(id1);
		reviews.put(id1++, r3);

		Review r4 = new Review(1L, 5L, "a familia eh os amigos que fazemos no meio do caminho", 10);
		r4.setId(id1);
		reviews.put(id1++, r4);

		Review r5 = new Review(5L, 4L, "achei melhor que os dois primeiros falei to leve", 8);
		r5.setId(id1);
		reviews.put(id1, r5);

		setMaxId(id1);
	}

	public HashMap<Long, Review> getHashMapReviews() {
		return this.reviews;
	}

	public Review getReview(Long id){
		 
		Review get = null;

		if(reviews.containsKey(id)){
			
			get = reviews.get(id);
			
		}
		
		return get;
	}

	public List<Review> GetAll () {
		List<Review> todasAsReviews = new ArrayList <Review> (reviews.values());
		
		return todasAsReviews;
	}
	
	public List<Review> getReviewsFilme(Long filmeId){
		
		List<Review> todasAsReviews = new ArrayList <Review>(reviews.values());	
		
		List<Review> reviewsFiltradas = new ArrayList <Review>();
		
		for(Review review : todasAsReviews){
			
			if(review.getIdfilme().equals(filmeId)){
				
				reviewsFiltradas.add(review);
			}
			
		}
		
		return reviewsFiltradas;
	}

	public Review addReview(Review review) {
		reviews.put(review.getId(), review);
		return review;
	}

	public boolean deleteReview(Long id) {
		reviews.remove(id);
		if (reviews.containsKey(id)) {
			return false;
		}
		return true;
	}

}

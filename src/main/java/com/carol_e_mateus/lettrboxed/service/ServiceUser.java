package com.carol_e_mateus.lettrboxed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carol_e_mateus.lettrboxed.dto.FilmeResumoDTO;
import com.carol_e_mateus.lettrboxed.dto.ReviewDTO;
import com.carol_e_mateus.lettrboxed.dto.ReviewResumoDTO;
import com.carol_e_mateus.lettrboxed.dto.UserDTO;
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
    
    //Review para reviewResumoDTO
    public ReviewResumoDTO converterReviewParaDTO(Review review) {
    	
    	String filme = repositoryFilme.getFilm(review.getIdfilme()).getTitulo();
    	
    	String username = repositoryUser.getUser(review.getDono()).getNome();
    	
    	ReviewResumoDTO reviewResumoDTO = new ReviewResumoDTO(filme, review.getTexto(), review.getNota());
    	
    	return reviewResumoDTO;
    	
    }
    
    //Filme para filmeResumoDTO
    public FilmeResumoDTO converterFilmeParaDTO(Filme filme) {
    	
    	FilmeResumoDTO filmeDTO = new FilmeResumoDTO(filme.getId(), filme.getTitulo());
    	
    	return filmeDTO;
    	
    }
    
    //User para DTO
    public UserDTO converterParaDTO(User user) {
    	
    	//Reviews -> dto
    	
    	List<Review> reviews = new ArrayList<>();
    	
    	for(Long id : user.getReviews()) {
    		reviews.add(repositoryReview.getReview(id));
    	}
    	
    	List<ReviewResumoDTO> reviewsResumidas = new ArrayList<>();
    	
    	for(Review review : reviews){
    		
    		reviewsResumidas.add(converterReviewParaDTO(review));
    	}
    	
    	//Filmes -> dto
    	
    	List<Filme> filmes = new ArrayList<>();
    	
    	for(Long id : user.getFilmesAssistidos()) {
    		filmes.add(repositoryFilme.getFilm(id));
    	}
    	
    	List<FilmeResumoDTO> filmesResumidos = new ArrayList<>();
    	
    	for(Filme filme : filmes){
    		
    		filmesResumidos.add(converterFilmeParaDTO(filme));
    	}
    	
    	//Long id, String name, String email, List<ReviewResumoDTO> reviews, List<FilmeResumoDTO> filmesAssistidos
    	
    	UserDTO userDTO = new UserDTO (user.getId(),user.getNome(),user.getEmail(),reviewsResumidas,filmesResumidos);
    	
    	return userDTO;
    	
    }

    public UserDTO createUser(User user) {
        repositoryUser.createUser(user);
        user.setId(counter);
        counter++;
        
        UserDTO userDTO = converterParaDTO(user);
        
        return userDTO;
    }

    public UserDTO getUser(Long id) {
    	
    	User user = repositoryUser.getUser(id);

        if (user != null) {
        	
            UserDTO userDTO = converterParaDTO(user);
        	
            return userDTO;
        }
        return null;
    }

    public UserDTO updateUser(User u) {
    	User user  = repositoryUser.getUser(u.getId()).updateUser(u);
    	 UserDTO userDTO = converterParaDTO(user);
    	
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {

        List<User> a = new ArrayList<>(repositoryUser.getAll());
        
        List<UserDTO> usersDTO = new ArrayList<>();
        
        for(User user : a) {
        	
        	 UserDTO userDTO = converterParaDTO(user);
        	
        	 usersDTO.add(userDTO);
        }
        
        
        return usersDTO;
        
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

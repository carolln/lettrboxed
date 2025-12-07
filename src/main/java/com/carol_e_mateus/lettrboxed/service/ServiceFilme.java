package com.carol_e_mateus.lettrboxed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carol_e_mateus.lettrboxed.dto.FilmeDTO;
import com.carol_e_mateus.lettrboxed.dto.ReviewResumoDTO;
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

    private Long counter;

    @PostConstruct
    public void inicializarCounter() {
        Long maxid = repositoryFilme.getMaxId();
        counter = new Long(maxid + 1);
    }

    @PostConstruct
	public void initializeFilmes() {
        List<Review> eu2 = repositoryReview.GetAll();

		for (Review u : eu2) { // passar por todos os reviews e adiciona-los aos seus devidos users
            repositoryFilme.AddReviewToFilme(u, u.getIdfilme());
		}
	}
    
    public FilmeDTO converterParaDTO(Filme filme){
    	
        List<Review> reviews = repositoryReview.getReviewsFilme(filme.getId());
        
        List<ReviewResumoDTO> reviewsDTO = new ArrayList<>();
       
        //Pega as reviews do filme e transforma em reviewsDTO
        for(Review review : reviews) {
        	
        	String filmeNome = repositoryFilme.getFilm(review.getIdfilme()).getTitulo();
        	
        	String username = repositoryUser.getUser(review.getDono()).getNome();
        	
        	ReviewResumoDTO reviewResumidaDTO = new ReviewResumoDTO(username, review.getTexto(),review.getNota());
    		
        	reviewsDTO.add(reviewResumidaDTO);
        	
        }      
        
        FilmeDTO filmeDto = new FilmeDTO(filme.getId(),filme.getTitulo(),filme.getDescricao(),filme.getGenero(),filme.getClassificao(),filme.getAnoLancamento() ,reviewsDTO);
        
    	return filmeDto;	
    }

    
	
    public FilmeDTO createFilme(Filme f){

        Filme ff = new Filme(f.getTitulo(), f.getDescricao(), f.getDiretor(), f.getGenero(), f.getClassificao(), f.getAnoLancamento());
        ff.setId(counter);
        counter++;
        
        //DTO
        Filme filme = repositoryFilme.createFilme(ff);
        
        FilmeDTO filmeDTO = converterParaDTO(filme);
        
        return filmeDTO;
    }

    
    public FilmeDTO getFilme(Long id){
    	
    	Filme filme = repositoryFilme.getFilm(id);

        if (filme != null) {
        	
            FilmeDTO filmeDTO = converterParaDTO(filme);
        	
            return filmeDTO;
        }
        return null;
    }

    public List<FilmeDTO> getAllFilmes(){
    	
    	List<Filme> filmes = repositoryFilme.getAll();
    	
    	List<FilmeDTO> filmesDTO = new ArrayList<>();
    	
    	for(Filme filme : filmes) {
    		
    		filmesDTO.add(converterParaDTO(filme));
    	}
    	
        return filmesDTO;
    }

    
    public FilmeDTO updateFilme(Filme f) {
        
        repositoryFilme.getFilm(f.getId()).updateFilme(f);
        
        FilmeDTO filmeDTO = converterParaDTO(f);
        
        return filmeDTO;
    }
    
    public boolean deleteFilme(Long id){
        // delete film
        
        // apagar todos os reviews do filme em especifico
        for (Long review : repositoryFilme.getFilm(id).getReviews()) { // lista de reviews do filme
            //       ^^ESSE EH O ID DO REVIEW QUE DEVE SER APAGADO
            
            repositoryUser.getUser(repositoryReview.getReview(review).getDono()).deleteReview(review);
            repositoryReview.deleteReview(review); // deleta o review do filme da lista de reviews geral
            //aqui eu:
            // 1 - busco o review no repositorio que tem como id o review da vez
            // 2 - pego o id do dono (user que fez o review)
            // 3 - pego esse user em questao
            // 4 - tiro o review da vez da lista de reviews do user dono
        }

        repositoryFilme.deleteFilme(id);
        
        return true;
    }

    public List<FilmeDTO> filtrarFilmes(double nota) {
        double a = nota;
        List<Filme> passaro = new ArrayList<Filme>();

        for (Filme f : repositoryFilme.getAll()) { // faz um monte de casting e checa se a nota media eh maior do que a estabelecida
            if (getRatingMedio(f.getId()) >= a) {
                passaro.add(f);
            }
        }
        
        List<FilmeDTO> filmesDTO = new ArrayList <>();
        
        for(Filme filme : passaro) {
        	
        	filmesDTO.add(converterParaDTO(filme));
        	
        }

        return filmesDTO;
    }

    public double getRatingMedio (Long id) {
        // to do
        double runsum = 0;
        double cont = 0;
    
        for (Review review : repositoryReview.GetAll()) {
            if (review.getIdfilme() == id) {
                double temp = review.getNota();
                runsum+=temp;
                cont++;
            }
        }
    
        if (cont == 0) {
            return 0D;
        }
    
        return runsum / cont;
    
        
    }
}

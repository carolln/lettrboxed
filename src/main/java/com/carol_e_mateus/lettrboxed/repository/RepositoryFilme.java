package com.carol_e_mateus.lettrboxed.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.carol_e_mateus.lettrboxed.model.*;

@Repository
public class RepositoryFilme {
	
	private HashMap <Long, Filme> filmes = new HashMap <>();

	private Long maxId;

	public Long getMaxId() {
		return maxId;
	}

	public void setMaxId(Long l) {
		this.maxId = l;
	}
	
	
	public RepositoryFilme() {
		
		Long numero = 1L;
		
		Filme f1 = new Filme(numero,"Interestelar", "Um filme top sobre estrelas", "christopher nolan", "epic sci fi", 10, 14);
		
		Filme f2 = new Filme(++numero, "Planeta dos macacos", "Um filme cheio de macacos", "franklin j schaffner", "sci fi", 14, 1968);

		Filme f3 = new Filme(++numero, "Homem aranha: atraves do spiderverso", "o coitado do miles percebe que ele eh um erro :broken-heart:", "joaquim dos santos", "superhero animation", 13, 2023);

		Filme f4 = new Filme(++numero, "Wonka", "willy wonka retorna, dessa vez cantando mais!", "paul king", "fantasia musical", 0, 2023);

		Filme f5 = new Filme(++numero, "gato de botas: the last wish", "Um film que nos faz refletir sobre a real definição de família e o nosso lugar no mundo", "joel crawford", "comedia aventura", 0, 2022);


		filmes.put(f1.getId(), f1);
		filmes.put(f2.getId(), f2);
		filmes.put(f3.getId(), f3);
		filmes.put(f4.getId(), f4);
		filmes.put(f5.getId(), f5);
		setMaxId(numero);

	}
	

	public Filme getFilm(Long id){
		 
		Filme get = null;

		if(filmes.containsKey(id)){
			
			get = filmes.get(id);
			
		}
		
		return get;
	}
	
	public List<Filme> getAll(){
		
		List<Filme> todosOsFilmes = new ArrayList <Filme> (filmes.values());
		
		return todosOsFilmes;
	}

	public Filme createFilme(Filme f) {
		filmes.put(f.getId(), f);
		return f;
	}

	public boolean AddReviewToFilme(Review review, Long id) {
		if (filmes.get(id) != null) {
			filmes.get(id).addReview(review);
			return true;
		}
		return false;
	}

	public void deleteFilme(Long id) {
		filmes.remove(id);
	}

	public boolean deleteReviewFromFilme(Long idFilme, Long IdReview) {
		return filmes.get(idFilme).deleteReview(IdReview);
	}


}

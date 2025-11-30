package com.carol_e_mateus.lettrboxed.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.carol_e_mateus.lettrboxed.model.Filme;

@Repository
public class RepositoryFilme {
	
	private HashMap <Long, Filme> filmes = new HashMap <>();
	
	
	public RepositoryFilme() {
		
		Long numero = 1L;
		
		Filme f1 = new Filme(numero,"Interestelar", "Um filme top sobre estrelas");
		
		Filme f2 = new Filme(++numero, "Planeta dos macacos", "Um filme cheio de macacos");
			
		filmes.put(f1.getId(), f1);
		filmes.put(f2.getId(), f2);

	}
	
	//Falta implementar
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

}

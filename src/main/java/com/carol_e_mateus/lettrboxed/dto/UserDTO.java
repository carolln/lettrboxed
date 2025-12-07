package com.carol_e_mateus.lettrboxed.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
	
    private Long id;
    
	private String name;

    private String email;
    
    private List<ReviewResumoDTO> reviews = new ArrayList<>();
    
    private List<FilmeResumoDTO> filmesAssistidos = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public List<ReviewResumoDTO> getReviews() {
		return reviews;
	}

	public List<FilmeResumoDTO> getFilmesAssistidos() {
		return filmesAssistidos;
	}

	public UserDTO(Long id, String name, String email, List<ReviewResumoDTO> reviews, List<FilmeResumoDTO> filmesAssistidos) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.reviews = reviews;
		this.filmesAssistidos = filmesAssistidos;
	}
    
    

}

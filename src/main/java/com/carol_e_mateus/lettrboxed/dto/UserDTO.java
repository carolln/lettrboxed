package com.carol_e_mateus.lettrboxed.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
	
    private Long id;
    
	private String name;

    private String email;
    
    private List<ReviewDTO> reviews = new ArrayList<>();
    
    private List<String> filmesAssistidos = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public List<String> getFilmesAssistidos() {
		return filmesAssistidos;
	}

	public UserDTO(Long id, String name, String email, List<ReviewDTO> reviews, List<String> filmesAssistidos) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.reviews = reviews;
		this.filmesAssistidos = filmesAssistidos;
	}
    
    

}

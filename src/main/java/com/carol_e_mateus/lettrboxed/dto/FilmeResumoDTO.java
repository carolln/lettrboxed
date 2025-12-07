package com.carol_e_mateus.lettrboxed.dto;

public class FilmeResumoDTO {
	
	private Long id;

	private String titulo;

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public FilmeResumoDTO(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}
	
}

package com.carol_e_mateus.lettrboxed.dto;

public class ReviewDTO {
	
	private Long id;
	
	private String user;
	
	private String filme;
	
	private String texto;

	public Long getId() {
		return id;
	}

	public String getDono() {
		return user;
	}

	public String getFilme() {
		return filme;
	}

	public String getTexto() {
		return texto;
	}

	public ReviewDTO(Long id, String dono, String filme, String texto) {
		super();
		this.id = id;
		this.user = dono;
		this.filme = filme;
		this.texto = texto;
	}

}

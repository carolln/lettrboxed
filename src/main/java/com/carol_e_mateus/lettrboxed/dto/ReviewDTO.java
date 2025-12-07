package com.carol_e_mateus.lettrboxed.dto;

public class ReviewDTO {
	
	private Long id;
	
    private Long userId;
    
    private Long filmeId;
	
	private String user;
	
	private String filme;
	
	private String texto;
	
	private int nota;

	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}


	public Long getFilmeId() {
		return filmeId;
	}


	public String getUser() {
		return user;
	}

	public String getFilme() {
		return filme;
	}

	public String getTexto() {
		return texto;
	}
	
	
	public int getNota() {
		return nota;
	}

	public ReviewDTO(Long id, Long userId, Long filmeId, String user, String filme, String texto, int nota) {
		super();
		this.id = id;
		this.userId = userId;
		this.filmeId = filmeId;
		this.user = user;
		this.filme = filme;
		this.texto = texto;
		this.nota = nota;
	}

	


}

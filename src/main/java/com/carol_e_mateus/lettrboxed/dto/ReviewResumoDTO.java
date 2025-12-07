package com.carol_e_mateus.lettrboxed.dto;

public class ReviewResumoDTO {
	
	private String user;
	
	private String texto;
	
	private int nota;	

	public String getUser() {
		return user;
	}

	public String getTexto() {
		return texto;
	}

	public int getNota() {
		return nota;
	}

	public ReviewResumoDTO(String user, String texto, int nota) {
		super();
		this.user = user;
		this.texto = texto;
		this.nota = nota;
	}
	
	

}

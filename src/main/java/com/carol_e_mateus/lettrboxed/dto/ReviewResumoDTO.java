package com.carol_e_mateus.lettrboxed.dto;

public class ReviewResumoDTO {
	
	private String filme;
	
	private String texto;
	
	private int nota;	

	public String getFilme() {
		return filme;
	}

	public String getTexto() {
		return texto;
	}

	public int getNota() {
		return nota;
	}

	public ReviewResumoDTO(String filme, String texto, int nota) {
		super();
		this.filme = filme;
		this.texto = texto;
		this.nota = nota;
	}
	
	

}

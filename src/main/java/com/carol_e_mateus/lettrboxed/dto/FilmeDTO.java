package com.carol_e_mateus.lettrboxed.dto;

import java.util.List;

public class FilmeDTO {
	
	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	private String genero;
	
    private int classificao;
    
    private int anoLancamento;
    
    private List<ReviewResumoDTO> reviews;

	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}


	public String getDescricao() {
		return descricao;
	}

	public String getGenero() {
		return genero;
	}

	public int getClassificao() {
		return classificao;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public List<ReviewResumoDTO> getReviews() {
		return reviews;
	}

	public FilmeDTO(Long id, String titulo, String descricao, String genero, int classificao, int anoLancamento,
			List<ReviewResumoDTO> reviews) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.genero = genero;
		this.classificao = classificao;
		this.anoLancamento = anoLancamento;
		this.reviews = reviews;
	}
 
}

package com.carol_e_mateus.lettrboxed.dto;

public class FilmeDTO {
	
	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	private String genero;
	
    private int classificao;
    
    private int anoLancamento;

	public Long getId() {
		return id;
	}

	public String getNome() {
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

	public FilmeDTO(Long id, String nome, String descricao, String genero, int classificao, int anoLancamento) {
		super();
		this.id = id;
		this.titulo = nome;
		this.descricao = descricao;
		this.genero = genero;
	}
    
	
    
}

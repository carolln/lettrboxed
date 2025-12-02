package com.carol_e_mateus.lettrboxed.model;
import java.util.ArrayList;
import java.util.List;


public class Filme {
	
    private Long id;

    private String titulo;
    
    private String descricao;
    
    private String diretor;
    
    private String genero;
    
    private int classificao;
    
    private int anoLancamento;

    private List<Long> reviews = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getDiretor() {
		return diretor;
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

	public List<Long> getReviews() {
		return reviews;
	}

	public Filme(Long id, String titulo, String descricao, String diretor, String genero, int classificao, int anoLancamento) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
        this.diretor = diretor;
        this.genero = genero;
        this.classificao = classificao;
        this.anoLancamento = anoLancamento;
	}
	
	
	
       
}

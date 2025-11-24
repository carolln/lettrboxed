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
       
}

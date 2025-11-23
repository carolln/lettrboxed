package com.carol_e_mateus.lettrboxed.model;
import java.util.ArrayList;
import java.util.List;


public class Filme {
    private Long id;

    private String titulo;
    private String descricao;
    private String diretor;
    private int ano_lancamento;

    private List<Review> reviews = new ArrayList<>();
}

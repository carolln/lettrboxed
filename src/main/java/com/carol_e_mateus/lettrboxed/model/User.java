package com.carol_e_mateus.lettrboxed.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    
    private String nome;
    
    private String email;

    private List<Long> reviews = new ArrayList<>();
    
    private List<Long> filmesAssistidos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Long> getReviews() {
        return reviews;
    }

    public List<Long> getFilmesAssistidos() {
        return filmesAssistidos;
    }

    public User(Long id, String nome, String email, List<Long> reviews, List<Long> filmesAssistidos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.reviews = reviews;
        this.filmesAssistidos = filmesAssistidos;
    }


}

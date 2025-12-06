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

    public void setId(Long idd) {
        this.id = idd;
    }

    public void setFilmesAssistidos(ArrayList<Long> ar) {
        this.filmesAssistidos = ar;
    }

    public User(){}

    public User(Long id, String nome, String email, List<Long> reviews, List<Long> filmesAssistidos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.reviews = reviews;
        this.filmesAssistidos = filmesAssistidos;
    }

    public User(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.reviews = user.getReviews();
        this.filmesAssistidos = user.getFilmesAssistidos();
    }

    public User(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.reviews = new ArrayList<>();
        this.filmesAssistidos = new ArrayList<>();
    }
    

    public void addReview(Review review) {
        reviews.add(review.getId());
    }

    public boolean deleteReview(Long IdReview) {
        return reviews.remove(IdReview);
    }

    public User updateUser(User u) {
        this.nome = u.nome;
        this.email = u.email;
        return this;
    }


}

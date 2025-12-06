package com.carol_e_mateus.lettrboxed.model;

public class Review {

    private Long id;
    
    private Long dono;
    
    private Long idfilme;
    
    private String texto;
    
    private int nota;

    public Review() {}

    public Review(Long dono, Long idfilme, String texto, int nota) {
        this.dono = dono;
        this.idfilme = idfilme;
        this.texto = texto;
        this.nota = nota;
    }

    public Review(Review r) {
        this.dono = r.dono;
        this.idfilme = r.idfilme;
        this.texto = r.texto;
        this.nota = r.nota;
        this.id = r.id;
    }
    
    public Long getId() {
        return id;
    }
    
    public Long getDono() {
        return dono;
    }
    
    public Long getIdfilme() {
        return idfilme;
    }
    
    public String getTexto() {
        return texto;
    }
    
    public int getNota() {
        return nota;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setDono(Long a) {
        this.dono = a;
    }

    public void setIdFilme(Long a) {
        this.idfilme = a;
    }

    public Review 
    updateReview(Review r) {
        this.texto = r.texto;
        this.nota = r.nota;

        return this;
    }

}

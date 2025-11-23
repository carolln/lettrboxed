package com.carol_e_mateus.lettrboxed.service;

import org.springframework.stereotype.Service;
import com.carol_e_mateus.lettrboxed.model.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceFilme {
    public Filme createFilme(Filme filme){

        // to do
        return filme;
    }

    public Filme getFilme(Long id){

        // to do
        Filme a = new Filme();
        return a;
    }

    public List<Filme> getAllFilmes(Filme filme){

        // to do
        // o corpo atual eh so pra nao ficar reclamando
        List<Filme> a = new ArrayList<>();
        return a;
    }

    public void deleteFilme(Long id) {
        // to do
    }

    public double getRatingMedio (Long id) {
        // to do
        return 0.00;
    }
}

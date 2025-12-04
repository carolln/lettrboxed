package com.carol_e_mateus.lettrboxed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carol_e_mateus.lettrboxed.model.*;
import com.carol_e_mateus.lettrboxed.repository.RepositoryFilme;
import com.carol_e_mateus.lettrboxed.repository.RepositoryReview;
import com.carol_e_mateus.lettrboxed.repository.RepositoryUser;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ServiceReview {

    @Autowired
	RepositoryFilme repositoryFilme;

    @Autowired
    RepositoryUser repositoryUser;

    @Autowired
    RepositoryReview repositoryReview;
    
    private Long counter;

    @PostConstruct
    public void inicializarCounter() {
        Long maxid = repositoryReview.getMaxId();
        counter = new Long(maxid + 1);
    }


    public List<Review> getReviewsFilme(Long idFilme) {
        // to do
        List<Review> a = new ArrayList<>();
        return a;
    }

    public Review getReview(Long id) {
        return repositoryReview.getReview(id);
    }

    public List<Review> GetAllReviews() {
        return repositoryReview.GetAll();
    }

    public Review createReview(Review review) {

        // antes aqui tem que checar se a pessoa ja fez um review, se sim overrida o antigo e mantem o id

        // adiciona um id que a gente cria

        review.setId(counter);
        counter++;

        // adiciona review ao repositorio de reviews
        repositoryReview.addReview(review);

        // adiciona id do review na lista de reviews do usuario dono
        repositoryFilme.AddReviewToFilme(review, review.getIdfilme());

        // adiciona review na lista de reviews do filme especifico
        repositoryUser.AddReviewToUser(review, review.getDono());
        return review;
    }

    public Review updateReview(Review r) {

        // se o dono for diferente

        if (r.getDono() != repositoryReview.getReview(r.getId()).getDono()) { // ve se o novo dono eh engual ao dono que tem no review original de mesmo id (dono antigo)

            repositoryUser.getUser(repositoryReview.getReview(r.getId()).getDono()).deleteReview(r.getId()); //pega o user que eh o dono antigo e deleta o review de mesmo numero que o atual

            repositoryUser.getUser(r.getDono()).addReview(r); // adiciona o id na lista do dono novo

            repositoryReview.getReview(r.getId()).setDono(r.getDono());
        }

        // se o filme for diferente

        if (r.getIdfilme() != repositoryReview.getReview(r.getId()).getIdfilme()) { // ve se o filme novo eh igual ao que tava com o mesmo id antes

            // tira o id da lista de reviews do filme
            repositoryFilme.getFilm(repositoryReview.getReview(r.getId()).getIdfilme()).deleteReview(r.getIdfilme());
            
            // adiciona o id na lista de reviews do novo filme
            repositoryFilme.getFilm(r.getIdfilme()).addReview(r);

            repositoryReview.getReview(r.getId()).setIdFilme(r.getIdfilme());
        }

        // substitui todos os valores no objeto original de review
        return repositoryReview.getReview(r.getId()).updateReview(r);
    }

    public boolean deleteReview(Long id) {

        // checa se existe o review do id passado
        if (!repositoryReview.getHashMapReviews().containsKey(id)) {
            return true;
        }

        // salva os valores tho
        Review r = new Review(repositoryReview.getReview(id));

        //se sim, tira ele do repositorio de reviews
        boolean a = repositoryReview.deleteReview(id);

        // apaga ele da lista de reviews do filme em especifico que ele faz parte
        
        boolean b = repositoryFilme.getFilm(r.getIdfilme()).deleteReview(r.getId());

        // apaga ele da lista de reviews do user que ele faz parte

        boolean c = repositoryUser.getUser(r.getDono()).deleteReview(r.getId());

        if (a == b && b == c && a == true) {
            return true;
        }

        return false;
    }
}

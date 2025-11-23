package com.carol_e_mateus.lettrboxed.service;

import org.springframework.stereotype.Service;
import com.carol_e_mateus.lettrboxed.model.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceReview {
    
    public Review createReview(Long idUser, Long idFilme, Review review) {
        // to do

        Review a = new Review();
        return a;
    }

    public List<Review> getReviewsFilme(Long idFilme) {
        // to do
        List<Review> a = new ArrayList<>();
        return a;
    }
}

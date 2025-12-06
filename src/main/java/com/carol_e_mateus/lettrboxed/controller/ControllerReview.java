package com.carol_e_mateus.lettrboxed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carol_e_mateus.lettrboxed.dto.ReviewDTO;
import com.carol_e_mateus.lettrboxed.model.*;
import com.carol_e_mateus.lettrboxed.service.*;
import java.util.*;

@RestController
@RequestMapping("/reviews")
public class ControllerReview {

    @Autowired
    ServiceReview serviceReview;

    @GetMapping
    public List<ReviewDTO> GetAllReviews() {
        return serviceReview.GetAllReviews();
    }

    @GetMapping("/{id}")
    public ReviewDTO getReview(@PathVariable Long id) {
        return serviceReview.getReview(id);
    }
    
    @PostMapping
    public ReviewDTO createReview(@RequestBody Review r) {
        return serviceReview.createReview(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        boolean deletou = serviceReview.deleteReview(id);

        if (!deletou) {
            return ResponseEntity.notFound().build(); // nao achou e retorna o erro 404
        }

        return ResponseEntity.noContent().build(); // deletou ai retorna um corpo vazio
    }

    @PutMapping("/put")
    public ReviewDTO updateReview(@RequestBody Review r) {
        return serviceReview.updateReview(r);
    }

}

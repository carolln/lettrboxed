package com.carol_e_mateus.lettrboxed.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    
    private String nome;
    
    private String email;

    private List<Long> reviews = new ArrayList<>();
    
    private List<Long> filmesAssistidos = new ArrayList<>();
}

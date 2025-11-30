package com.carol_e_mateus.lettrboxed.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.carol_e_mateus.lettrboxed.model.User;

@Repository
public class RepositoryUser {
	
	private HashMap <Long, User> users = new HashMap<>();

}

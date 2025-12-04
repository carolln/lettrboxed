package com.carol_e_mateus.lettrboxed.repository;

import java.util.*;
import org.springframework.stereotype.Repository;

import com.carol_e_mateus.lettrboxed.model.*;

import jakarta.annotation.PostConstruct;

@Repository
public class RepositoryUser {
	
	private HashMap <Long, User> users = new HashMap<>();


	RepositoryUser() {
		Long numero = 1L;

		User u1 = new User(numero, "jujubinharol", "carolina.nunes.c06@gmail.com");
		User u2 = new User(++numero, "aboutaxe", "mateus.oliveiraaaaa@gmail.com");
		User u3 = new User(++numero, "colorfuljam", "leomalima12@gmail.com");
		User u4 = new User(++numero, "ssugary", "hhtr.fresno@yahoo.com");
		User u5 = new User(++numero, "j3llyhuman", "aaaaaaaaaaaaaab@gmail.com");

		users.put(u1.getId(), u1);
		users.put(u2.getId(), u2);
		users.put(u3.getId(), u3);
		users.put(u4.getId(), u4);
		users.put(u5.getId(), u5);
		
	}

	public User getUser(Long id) {
		
		if (users.containsKey(id)) {
			return users.get(id);
		}

		return null;
	}

	public List<User> getAll(){
		
		List<User> todosOsUsers = new ArrayList <User> (users.values());
		
		return todosOsUsers;
	}

	public User createUser(User user) {
        users.put(user.getId(), user);
		return user;
    }

	public boolean AddReviewToUser(Review review, Long id) {
		
		if (users.get(id) != null) {
			users.get(id).addReview(review);
			return true;
		}

		return false;
	}

    public void deleteUser(Long id) {
       
		users.remove(id);
    }

}

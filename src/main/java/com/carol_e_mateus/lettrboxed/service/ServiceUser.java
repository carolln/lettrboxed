package com.carol_e_mateus.lettrboxed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carol_e_mateus.lettrboxed.model.*;
import com.carol_e_mateus.lettrboxed.repository.RepositoryUser;

import java.util.*;

@Service
public class ServiceUser {

    @Autowired
    RepositoryUser repositoryUser;

    public User createUser(User user) {
        // to do
        return user;
    }

    public User getUser(Long id) {

        if (repositoryUser.getUser(id) != null) {
            return repositoryUser.getUser(id);
        }
        return null;
    }

    public List<User> getAllUsers() {

        List<User> a = new ArrayList<>(repositoryUser.getAll());
        return a;
        
    }
}

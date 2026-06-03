package com.maurciobertuci.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurciobertuci.workshopmongo.domain.User;
import com.maurciobertuci.workshopmongo.exception.ObjectNotFoundException;
import com.maurciobertuci.workshopmongo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(id)
               .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
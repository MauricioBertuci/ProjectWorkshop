package com.maurciobertuci.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurciobertuci.workshopmongo.domain.Post;
import com.maurciobertuci.workshopmongo.exception.ObjectNotFoundException;
import com.maurciobertuci.workshopmongo.repository.PostRepository;


@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id)
               .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String title){
        return repo.findByTitleContainingIgnoreCase(title);
    }

}
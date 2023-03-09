package com.larramendi.workshopmongo.services;

import com.larramendi.workshopmongo.domain.Post;
import com.larramendi.workshopmongo.domain.User;
import com.larramendi.workshopmongo.dto.UserDto;
import com.larramendi.workshopmongo.repository.PostRepository;
import com.larramendi.workshopmongo.repository.UserRepository;
import com.larramendi.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}

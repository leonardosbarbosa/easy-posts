package com.leonardosbarbosa.easyposts.services;

import com.leonardosbarbosa.easyposts.models.dto.PostDTO;
import com.leonardosbarbosa.easyposts.models.entities.Post;
import com.leonardosbarbosa.easyposts.repositories.PostRepository;
import com.leonardosbarbosa.easyposts.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDTO findById(String id) {
        Post post = findEntityById(id);
        return new PostDTO(post);
    }

    private Post findEntityById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }
}

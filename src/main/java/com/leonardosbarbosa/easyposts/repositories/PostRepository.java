package com.leonardosbarbosa.easyposts.repositories;

import com.leonardosbarbosa.easyposts.models.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}

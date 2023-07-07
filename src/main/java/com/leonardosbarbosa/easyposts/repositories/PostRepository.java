package com.leonardosbarbosa.easyposts.repositories;

import com.leonardosbarbosa.easyposts.models.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
    @Query("{'title': { $regex: ?0, $options: 'i'} }")
    List<Post> searchTitleContaining(String text);
}

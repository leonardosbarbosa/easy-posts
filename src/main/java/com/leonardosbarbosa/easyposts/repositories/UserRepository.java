package com.leonardosbarbosa.easyposts.repositories;

import com.leonardosbarbosa.easyposts.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

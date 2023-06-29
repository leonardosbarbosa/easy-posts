package com.leonardosbarbosa.easyposts.repositories;

import com.leonardosbarbosa.easyposts.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}

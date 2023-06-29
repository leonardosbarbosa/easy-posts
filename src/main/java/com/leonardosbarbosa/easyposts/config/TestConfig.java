package com.leonardosbarbosa.easyposts.config;

import com.leonardosbarbosa.easyposts.models.entities.User;
import com.leonardosbarbosa.easyposts.repositories.PostRepository;
import com.leonardosbarbosa.easyposts.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class TestConfig {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public TestConfig(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @PostConstruct
    public void init() {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User leonardo = new User(null, "Leonardo Barbosa", "leonardo@email.com");
        User maria = new User(null, "Maria Brown", "maria@email.com");
        User bob = new User(null, "Bob grey", "bob@email.com");
        userRepository.saveAll(List.of(leonardo, maria, bob));
    }
}

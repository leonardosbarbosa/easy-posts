package com.leonardosbarbosa.easyposts.config;

import com.leonardosbarbosa.easyposts.models.entities.User;
import com.leonardosbarbosa.easyposts.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class TestConfig {

    private final UserRepository userRepository;

    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        userRepository.deleteAll();
        User leonardo = new User(null, "Leonardo Barbosa", "leonardo@email.com");
        User maria = new User(null, "Maria Brown", "maria@email.com");
        User bob = new User(null, "Bob grey", "bob@email.com");
        userRepository.saveAll(List.of(leonardo, maria, bob));
    }
}

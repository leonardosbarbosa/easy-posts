package com.leonardosbarbosa.easyposts.services;

import com.leonardosbarbosa.easyposts.models.dto.UserDTO;
import com.leonardosbarbosa.easyposts.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        var users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }
}

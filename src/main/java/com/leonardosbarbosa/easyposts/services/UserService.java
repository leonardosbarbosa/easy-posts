package com.leonardosbarbosa.easyposts.services;

import com.leonardosbarbosa.easyposts.models.dto.UserDTO;
import com.leonardosbarbosa.easyposts.models.entities.User;
import com.leonardosbarbosa.easyposts.repositories.UserRepository;
import com.leonardosbarbosa.easyposts.services.exceptions.ResourceNotFoundException;
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

    public UserDTO findById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        return new UserDTO(user);
    }

    public UserDTO createNew(UserDTO userDTO) {
        User entity = new User(userDTO);
        entity = userRepository.insert(entity);
        return new UserDTO(entity);
    }
}

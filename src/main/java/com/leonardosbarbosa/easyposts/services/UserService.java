package com.leonardosbarbosa.easyposts.services;

import com.leonardosbarbosa.easyposts.models.dto.UserDTO;
import com.leonardosbarbosa.easyposts.models.entities.User;
import com.leonardosbarbosa.easyposts.repositories.UserRepository;
import com.leonardosbarbosa.easyposts.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

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
        User user = findEntityById(id);
        return new UserDTO(user);
    }

    public UserDTO createNew(UserDTO userDTO) {
        User entity = new User(userDTO);
        entity = userRepository.insert(entity);
        return new UserDTO(entity);
    }

    public UserDTO updateById(String id, UserDTO userDTO) {
        User userEntity = findEntityById(id);
        copyDtoToEntity(userDTO, userEntity);
        userEntity = userRepository.save(userEntity);
        return new UserDTO(userEntity);
    }

    public void deleteById(String id) {
        findEntityById(id);
        userRepository.deleteById(id);
    }

    private User findEntityById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    private void copyDtoToEntity(UserDTO dto, User entity) {
        if (nonNull(dto.getName())) {
            entity.setName(dto.getName());
        }
        if (nonNull(dto.getEmail())) {
            entity.setEmail(dto.getEmail());
        }
    }
}

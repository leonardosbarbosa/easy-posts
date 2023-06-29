package com.leonardosbarbosa.easyposts.resources;

import com.leonardosbarbosa.easyposts.models.dto.UserDTO;
import com.leonardosbarbosa.easyposts.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        var list = userService.findAll();
        return ResponseEntity.ok(list);
    }
}

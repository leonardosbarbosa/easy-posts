package com.leonardosbarbosa.easyposts.resources;

import com.leonardosbarbosa.easyposts.models.dto.PostDTO;
import com.leonardosbarbosa.easyposts.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostResource {

    private final PostService postService;

    public PostResource(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        var result = postService.findById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PostDTO>> findByTitleContaining(@RequestParam(name = "title") String text) {
        var result = postService.findByTitleContaining(text);
        return ResponseEntity.ok(result);
    }
}

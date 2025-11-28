package com.ctrindadedev.mongodb_spring.resources;

import com.ctrindadedev.mongodb_spring.dto.UserDTO;
import com.ctrindadedev.mongodb_spring.models.Post;
import com.ctrindadedev.mongodb_spring.models.User;
import com.ctrindadedev.mongodb_spring.service.PostService;
import com.ctrindadedev.mongodb_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}") // A chave {id} indica que é uma variável na URL
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }



}

package com.ctrindadedev.mongodb_spring.service;

import com.ctrindadedev.mongodb_spring.dto.UserDTO;
import com.ctrindadedev.mongodb_spring.models.Post;
import com.ctrindadedev.mongodb_spring.models.User;
import com.ctrindadedev.mongodb_spring.repository.PostRepository;
import com.ctrindadedev.mongodb_spring.repository.UserReposittory;
import com.ctrindadedev.mongodb_spring.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//Conversa com o repository
@Service
public class PostService {

    @Autowired //Spring procura a definição do objeto e instancia (injeção de dependencia do Spring)

    private PostRepository repo;
    public Post findById(String id){
        Post post = repo.findById(id).get();
        if(post == null){
            throw new ObjectNotFoundException("User not found");
        }
        return post;
    }



}

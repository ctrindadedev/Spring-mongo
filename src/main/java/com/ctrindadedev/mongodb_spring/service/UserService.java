package com.ctrindadedev.mongodb_spring.service;

import com.ctrindadedev.mongodb_spring.models.User;
import com.ctrindadedev.mongodb_spring.repository.UserReposittory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//Conversa com o repository
@Service
public class UserService {

    @Autowired //Spring procura a definição do objeto e instancia (injeção de dependencia do Spring)

    private UserReposittory repo;
    public List<User> findAll() {
        return repo.findAll();
    }
    public User save(User user) {

    }
}

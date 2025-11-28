package com.ctrindadedev.mongodb_spring.service;

import com.ctrindadedev.mongodb_spring.dto.UserDTO;
import com.ctrindadedev.mongodb_spring.models.User;
import com.ctrindadedev.mongodb_spring.repository.UserReposittory;
import com.ctrindadedev.mongodb_spring.service.exception.ObjectNotFoundException;
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
    public User findById(String id){
        User user = repo.findById(id).get();
        if(user == null){
            throw new ObjectNotFoundException("User not found");
        }
        return user;
    }

    public User insertUser(User user) {
       return repo.insert(user);

    }

    public void deleteUser(String id) {
         findById(id); //Já cobre possiveis erros
         repo.deleteById(id);
    }


    public User updateUser(User obj) {
        //Find objeto original do banco de dadoas
        User user = repo.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("User not found"));
        updateData(user, obj);
        return repo.save(user);
    }

    private void updateData(User user, User obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
    }


    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());

    }


}

package com.ctrindadedev.mongodb_spring.resources;

import com.ctrindadedev.mongodb_spring.dto.UserDTO;
import com.ctrindadedev.mongodb_spring.models.User;
import com.ctrindadedev.mongodb_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        //List a gente não implementa pois é uma interface, então instanciamos para usar
        List<User> users =  userService.findAll();
        List<UserDTO>  listUserDTO = users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listUserDTO);
    }
    @GetMapping(value = "/{id}") // A chave {id} indica que é uma variável na URL
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO objDto){
        User obj = userService.fromDTO(objDto);
        obj = userService.insertUser(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
        public ResponseEntity<Void> delete(@PathVariable String id) {
         userService.deleteUser(id);
         return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO objDto) {
        User obj = userService.fromDTO(objDto);
        obj.setId(id);
        userService.updateUser(obj);
        return ResponseEntity.noContent().build();
    }

}

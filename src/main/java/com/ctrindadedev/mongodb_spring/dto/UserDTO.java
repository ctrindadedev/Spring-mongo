package com.ctrindadedev.mongodb_spring.dto;


import com.ctrindadedev.mongodb_spring.models.User;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String email;

    public void userDTO(){

    }
    public UserDTO(@NotNull User userObj) {
        this.id = userObj.getId();
        this.name = userObj.getName();
        this.email = userObj.getEmail();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



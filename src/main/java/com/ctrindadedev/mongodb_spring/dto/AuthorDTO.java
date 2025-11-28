package com.ctrindadedev.mongodb_spring.dto;

import com.ctrindadedev.mongodb_spring.models.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public AuthorDTO() {}

    public AuthorDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();

    }
}

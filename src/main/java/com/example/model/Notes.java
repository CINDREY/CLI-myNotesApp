package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;



public class Notes implements Serializable {
    private long id;
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Notes() {
    }

    public Notes(long id) {
        this.id = id;
    }

    public Notes(String message) {
        this.message = message;
    }
}

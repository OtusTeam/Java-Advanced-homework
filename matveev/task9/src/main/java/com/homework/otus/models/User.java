package com.homework.otus.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name should not be blank")
    private String name;
    @NotNull
    private String password;

    public User() {}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

package com.dev.laedson.crmColumna.model;

import jakarta.persistence.*;
import org.springframework.scheduling.config.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "name")
    private String name;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;


    @OneToMany(mappedBy = "collaborator", cascade = CascadeType.ALL)
    private List<Project> projects = new ArrayList<>();


    public User() {
    }

    public User(UUID userId, String name, String telefone, String email, String password, String role) {
        this.userId = userId;
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.password = password;
        this.role = role;
    }


    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

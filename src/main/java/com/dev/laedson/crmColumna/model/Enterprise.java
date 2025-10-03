package com.dev.laedson.crmColumna.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_enterprise")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "enterprise_id")
    private UUID enterpriseId;

    @Column(name = "enterprise_name")
    private String enterpriseName;

    @Column(name = "CNPJ")
    private String CNPJ;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    public Enterprise() {
    }

    public Enterprise( String enterpriseName, String CNPJ, String category, User owner) {
        this.enterpriseName = enterpriseName;
        this.CNPJ = CNPJ;
        this.category = category;
        this.owner = owner;
        this.users = new ArrayList<>();
    }

    public UUID getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(UUID enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}

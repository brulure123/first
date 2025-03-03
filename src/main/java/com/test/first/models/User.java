package com.test.first.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"username"})
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username; 
     
    @NotNull  
    private String password;

    private int age;
    private Date birthdate;
    private String firstName;
    private String lastName;
    private String JobTitle;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER) // Ou Lazy si vous préférez
    @JoinTable(name = "users_roles", // Table de jointure entre users et roles
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles; // Liste des rôles de l'utilisateur
}

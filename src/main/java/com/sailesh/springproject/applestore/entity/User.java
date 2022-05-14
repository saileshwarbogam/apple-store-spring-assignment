package com.sailesh.springproject.applestore.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @NotEmpty
    @Column(nullable = false)
    @Size(min=3, max=20, message = "length should be in between 3 and 20")
    private String firstName;

    @NotEmpty(message = "can not be empty")
    private  String lastName;

    @Column(nullable = false, unique = true)
    @NotEmpty
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email pattern")
    private String email;

    @NotEmpty(message = "Password should not be empty")
    private  String password;


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID",referencedColumnName = "ID")}


    )
    private List<Role> roles;

    public User(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    public  User(){}
}

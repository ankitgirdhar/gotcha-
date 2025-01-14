package com.gotcha.game.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends Auditable{
    @Email
    @NotBlank
    @Column(unique = true)
    @Getter
    @Setter
    private String email;

    @NotBlank
    @Getter

    private String saltedHashPassword;

    public User() {
    }

    public void setSaltedHashPassword(String value) {
        this.saltedHashPassword = new BCryptPasswordEncoder(5).encode(value);
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @Getter
    @Setter
    Set<Role> roles = new HashSet<>();

    public User(User user) { // just a copy constructor... jo hame user mila h uske parameters hame as a apne properties chahiye....
        email = user.email;
        saltedHashPassword = user.getSaltedHashPassword();
        roles = user.getRoles();
    }
}

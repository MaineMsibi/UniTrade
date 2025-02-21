package com.backend.unitrade;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails {
    @Id
    @SequenceGenerator(
        name ="user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator =" user_sequence"
    )
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

    private Boolean locked = false;
    private Boolean enable = false;

    public AppUser(String firstname, String lastname, String email, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority((appUserRole.name()));
        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return email;
    }
}

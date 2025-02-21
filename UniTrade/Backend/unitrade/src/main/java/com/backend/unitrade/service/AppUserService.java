package com.backend.unitrade.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.tomcat.util.json.Token;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.unitrade.AppUser;
import com.backend.unitrade.repository.AppUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final TokenService tokenService;
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }
    public String signUpUser(AppUser appUser){
        boolean userExists = appUserRepository.findByEmail((appUser.getEmail())).isPresent();
        if(userExists){
            throw new IllegalStateException("User already exists");
        }
        String encodedPassword = null;
        // todo: We will create an encrypted password.

        appUser.setPassword(encodedPassword);
        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();
        Token confirmationToken = new Token(
            token,
            LocalDateTime.now(),
            LocalDateTime.now().plusMinutes(10),
            appUser

        );

        tokenService.saveConfirmationToken(confirmationToken);
        return token;
    }
    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
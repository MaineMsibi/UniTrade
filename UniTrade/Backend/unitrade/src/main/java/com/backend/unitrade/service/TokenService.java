package com.backend.unitrade.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.unitrade.Token;
import com.backend.unitrade.repository.TokenRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TokenService {
    private final TokenRepository tokenRepository;
    public void saveConfirmationToken(Token token) {
        tokenRepository.save(token);
    }
    public Optional<Token> getToken(String token){
        return tokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token){
        return tokenRepository.updateConfirmedAt(
            token, LocalDateTime.now());
    }
}

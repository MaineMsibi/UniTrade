package com.backend.unitrade.service;

import org.springframework.stereotype.Service;

import com.backend.unitrade.AppUser;
import com.backend.unitrade.AppUserRole;
import com.backend.unitrade.RegistrationRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final TokenService tokenService;

    public String register(RegistrationRequest request){
        AppUser appUser = new AppUser(
            request.getFirstname(), request.getLastname(),request.getEmail(),request.getPassword(),AppUserRole.USER
        );
        String token appUserService.signUpUser(appUser);
        String confirmationLink = "http://localhost:9090/registration/confirmation?token=" + token;
            //todo: send the email

            return token;

    }@Transactional
    public String confirmToken(String token) {
        String loginLink = "http://localhost:9090/registration/login";
        Token confirmationToken = tokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException(buildConfirmedPage(loginLink,"Email already confirmed."));
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        tokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return buildConfirmedPage(loginLink,"Email Confirmed");
    }

    private String buildEmail(String name, String link) {
        return
                "<p> Hi " + name +
                ",</p>" +
                "<p> Thank you for registering. Please click on the below link to activate your account: </p>" +
                "<blockquote><p> <a href=\"" + link + "\">Activate Now</a> </p></blockquote>\n Link will expire in 10 minutes.";
    }
    private String buildConfirmedPage(String link, String message){
        return "<p> " + message + ". Please click on the below link to Login: </p>" +
                "<blockquote><p> <a href=\"" + link + "\">Login</a> </p>";
    }
}
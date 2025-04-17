package ru.lebedev.faktura.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lebedev.faktura.dto.UserDto;
import ru.lebedev.faktura.service.KeycloakService;
import ru.lebedev.faktura.dto.TokenResponse;

@RestController
@RequestMapping("${api.url}")
@RequiredArgsConstructor
public class AuthController {

    private final KeycloakService keycloakService;

    @PostMapping("/login")
    public TokenResponse getAccessToken(@RequestBody UserDto dto) {
        return keycloakService.getAccessToken(dto.login(), dto.password());

    }

    @GetMapping("/hello")
    public String registerUser(@AuthenticationPrincipal Jwt jwt) {
        return "Hello %s!".formatted(jwt.getClaimAsStringList("preferred_username"));
    }

}




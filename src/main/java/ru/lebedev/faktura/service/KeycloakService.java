package ru.lebedev.faktura.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import ru.lebedev.faktura.dto.TokenResponse;
import ru.lebedev.faktura.feign.KeycloakFeignClient;

@Service
@RequiredArgsConstructor
public class KeycloakService {

    private final KeycloakFeignClient keycloakFeignClient;

    @Value("${client-id}")
    private String clientId;

    public TokenResponse getAccessToken(String username, String password) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", clientId);
        params.add("username", username);
        params.add("password", password);
        params.add("grant_type", "password");
        JsonNode tokenResponse = keycloakFeignClient.getAccessToken(params);
        return new TokenResponse(tokenResponse.get("access_token").asText());
    }

}

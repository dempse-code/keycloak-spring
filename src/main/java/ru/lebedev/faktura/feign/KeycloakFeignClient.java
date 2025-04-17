package ru.lebedev.faktura.feign;

import com.fasterxml.jackson.databind.JsonNode;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "keycloak",
        url = "${spring.security.oauth2.resourceserver.jwt.issuer-uri}/protocol/openid-connect/token"
)
public interface KeycloakFeignClient {

    @PostMapping
    @Headers("Content-Type: application/x-www-form-urlencoded")
    JsonNode getAccessToken(@RequestBody MultiValueMap<String, String> formParams);

}

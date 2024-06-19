package com.cs544.project.email.integration;


import com.cs544.project.email.adapter.EmailAdapter;
import com.cs544.project.email.domain.Email;
import com.cs544.project.email.dto.EmailOutgoingRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Component
public class Sender {
    @Value("${app.email_api.token}")
    private String bearerToken;

    @Value("${app.email_api.url}")
    private String url;

    public void sendEmail(Email email){
        EmailOutgoingRequest emailRequestDTO = EmailAdapter.INSTANCE.toEmailOutgoingRequest(email);
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        try {
            String jsonBody = objectMapper.writeValueAsString(emailRequestDTO);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                    .header("Authorization", "Bearer "+ bearerToken)
                    .header("Content-Type", "application/json")
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e){
            // TODO : Handle Exception may be log this info with error level
            System.out.println(e);
        }
    }
}

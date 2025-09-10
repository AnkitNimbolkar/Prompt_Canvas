package com.aiphoto.backend.service;

import com.aiphoto.backend.dto.ImageRequest;
import com.aiphoto.backend.dto.ImageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class ImageService {

    @Value("${openai.api.key}")
    private String openAiApiKey;

    private static final String OPENAI_URL = "https://api.openai.com/v1/images/generations";

    public ImageResponse generateImage(ImageRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        // Build request body
        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-image-1");  // OpenAI’s image model
        body.put("prompt", request.getPrompt());
        body.put("size", "512x512");

        // Build headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(openAiApiKey);

        // Wrap in entity
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        // Call OpenAI
        ResponseEntity<Map> response = restTemplate.exchange(
                OPENAI_URL,
                HttpMethod.POST,
                entity,
                Map.class
        );

        // Extract image URL
        List<Map<String, Object>> data = (List<Map<String, Object>>) response.getBody().get("data");
        String imageUrl = (String) data.get(0).get("url");

        return new ImageResponse(imageUrl);
    }
}


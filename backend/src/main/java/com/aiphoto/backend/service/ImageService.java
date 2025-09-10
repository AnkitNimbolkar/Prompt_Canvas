package com.aiphoto.backend.service;

import com.aiphoto.backend.dto.GenerateRequest;
import com.aiphoto.backend.dto.GenerateResponse;
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

    public GenerateResponse generateImage(GenerateRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-image-1");
        body.put("prompt", request.getPrompt());
        body.put("size", "1536x1024");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(openAiApiKey);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                OPENAI_URL,
                HttpMethod.POST,
                entity,
                Map.class
        );

        List<Map<String, Object>> data = (List<Map<String, Object>>) response.getBody().get("data");
        String imageUrl = (String) data.get(0).get("url");

        return new GenerateResponse(imageUrl);
    }
}

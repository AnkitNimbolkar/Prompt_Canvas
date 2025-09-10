package com.aiphoto.backend.controller;

import com.aiphoto.backend.dto.GenerateRequest;
import com.aiphoto.backend.dto.GenerateResponse;
import com.aiphoto.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "http://localhost:3000") // allow React frontend to call backend
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/generate")
    public GenerateResponse generateImage(@RequestBody GenerateRequest request) {
        return imageService.generateImage(request);
    }
}

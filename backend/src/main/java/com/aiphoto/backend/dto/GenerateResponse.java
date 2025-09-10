package com.aiphoto.backend.dto;

public class GenerateResponse {
    private String imageUrl;

    public GenerateResponse(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

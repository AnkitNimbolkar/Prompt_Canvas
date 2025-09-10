package com.aiphoto.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prompts")
public class PromptRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prompt;

    private String imageUrl;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
}

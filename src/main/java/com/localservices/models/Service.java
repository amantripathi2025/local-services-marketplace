package com.localservices.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Document(collection = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    private String id;
    private String providerId;
    private String name;
    private String description;
    private String category;
    private double price;
    private String duration; // e.g., "1 hour", "30 minutes"
    private String location;
    private double latitude;
    private double longitude;
    private String[] images;
    private double rating;
    private int totalReviews;
    private boolean available;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
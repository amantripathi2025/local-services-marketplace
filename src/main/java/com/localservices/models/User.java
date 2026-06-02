package com.localservices.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String userType; // "service_provider" or "customer"
    private String profileImage;
    private double rating;
    private int totalReviews;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean active;
}
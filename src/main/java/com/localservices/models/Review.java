package com.localservices.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Document(collection = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    private String id;
    private String bookingId;
    private String serviceId;
    private String providerId;
    private String customerId;
    private int rating; // 1-5 stars
    private String comment;
    private String[] images;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
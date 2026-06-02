package com.localservices.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Document(collection = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    private String id;
    private String customerId;
    private String serviceId;
    private String providerId;
    private String status; // "pending", "confirmed", "completed", "cancelled"
    private LocalDateTime bookingDate;
    private LocalDateTime serviceDate;
    private String serviceTime;
    private double totalPrice;
    private String location;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
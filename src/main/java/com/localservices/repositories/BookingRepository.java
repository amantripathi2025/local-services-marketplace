package com.localservices.repositories;

import com.localservices.models.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByCustomerId(String customerId);
    List<Booking> findByProviderId(String providerId);
    List<Booking> findByStatus(String status);
}
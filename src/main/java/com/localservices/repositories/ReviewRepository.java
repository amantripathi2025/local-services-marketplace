package com.localservices.repositories;

import com.localservices.models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByServiceId(String serviceId);
    List<Review> findByProviderId(String providerId);
    List<Review> findByCustomerId(String customerId);
}
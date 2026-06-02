package com.localservices.repositories;

import com.localservices.models.LocalService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceRepository extends MongoRepository<LocalService, String> {
    List<LocalService> findByProviderId(String providerId);
    List<LocalService> findByCategory(String category);
    List<LocalService> findByLocation(String location);
}

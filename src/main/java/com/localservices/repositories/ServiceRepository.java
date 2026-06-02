package com.localservices.repositories;

import com.localservices.models.LocalService;
import com.localservices.models.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceRepository extends MongoRepository<Service, String> {
    List<Service> findByProviderId(String providerId);
    List<Service> findByCategory(String category);
    List<Service> findByLocation(String location);
}
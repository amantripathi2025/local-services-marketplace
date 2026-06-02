package com.localservices.services;

import com.localservices.models.LocalService;
import com.localservices.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public LocalService createService(LocalService service) {
        service.setCreatedAt(LocalDateTime.now());
        service.setUpdatedAt(LocalDateTime.now());
        service.setAvailable(true);
        return serviceRepository.save(service);
    }

    public Optional<LocalService> getServiceById(String id) {
        return serviceRepository.findById(id);
    }

    public List<LocalService> getServicesByProviderId(String providerId) {
        return serviceRepository.findByProviderId(providerId);
    }

    public List<LocalService> getServicesByCategory(String category) {
        return serviceRepository.findByCategory(category);
    }

    public List<LocalService> getServicesByLocation(String location) {
        return serviceRepository.findByLocation(location);
    }

    public LocalService updateService(String id, LocalService serviceDetails) {
        Optional<LocalService> service = serviceRepository.findById(id);
        if (service.isPresent()) {
            LocalService existingService = service.get();
            existingService.setName(serviceDetails.getName());
            existingService.setDescription(serviceDetails.getDescription());
            existingService.setPrice(serviceDetails.getPrice());
            existingService.setAvailable(serviceDetails.isAvailable());
            existingService.setUpdatedAt(LocalDateTime.now());
            return serviceRepository.save(existingService);
        }
        return null;
    }

    public List<LocalService> getAllServices() {
        return serviceRepository.findAll();
    }

    public void deleteService(String id) {
        serviceRepository.deleteById(id);
    }
}

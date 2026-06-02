package com.localservices.services;

import com.localservices.models.Service;
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

    public Service createService(Service service) {
        service.setCreatedAt(LocalDateTime.now());
        service.setUpdatedAt(LocalDateTime.now());
        service.setAvailable(true);
        return serviceRepository.save(service);
    }

    public Optional<Service> getServiceById(String id) {
        return serviceRepository.findById(id);
    }

    public List<Service> getServicesByProviderId(String providerId) {
        return serviceRepository.findByProviderId(providerId);
    }

    public List<Service> getServicesByCategory(String category) {
        return serviceRepository.findByCategory(category);
    }

    public List<Service> getServicesByLocation(String location) {
        return serviceRepository.findByLocation(location);
    }

    public Service updateService(String id, Service serviceDetails) {
        Optional<Service> service = serviceRepository.findById(id);
        if (service.isPresent()) {
            Service existingService = service.get();
            existingService.setName(serviceDetails.getName());
            existingService.setDescription(serviceDetails.getDescription());
            existingService.setPrice(serviceDetails.getPrice());
            existingService.setAvailable(serviceDetails.isAvailable());
            existingService.setUpdatedAt(LocalDateTime.now());
            return serviceRepository.save(existingService);
        }
        return null;
    }

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public void deleteService(String id) {
        serviceRepository.deleteById(id);
    }
}
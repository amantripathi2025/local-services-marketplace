package com.localservices.controllers;

import com.localservices.models.Service;
import com.localservices.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "*")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        Service newService = serviceService.createService(service);
        return ResponseEntity.ok(newService);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Service>> getServiceById(@PathVariable String id) {
        Optional<Service> service = serviceService.getServiceById(id);
        return ResponseEntity.ok(service);
    }

    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<Service>> getServicesByProviderId(@PathVariable String providerId) {
        List<Service> services = serviceService.getServicesByProviderId(providerId);
        return ResponseEntity.ok(services);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Service>> getServicesByCategory(@PathVariable String category) {
        List<Service> services = serviceService.getServicesByCategory(category);
        return ResponseEntity.ok(services);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Service>> getServicesByLocation(@PathVariable String location) {
        List<Service> services = serviceService.getServicesByLocation(location);
        return ResponseEntity.ok(services);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable String id, @RequestBody Service serviceDetails) {
        Service updatedService = serviceService.updateService(id, serviceDetails);
        return ResponseEntity.ok(updatedService);
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> services = serviceService.getAllServices();
        return ResponseEntity.ok(services);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable String id) {
        serviceService.deleteService(id);
        return ResponseEntity.ok("Service deleted successfully");
    }
}
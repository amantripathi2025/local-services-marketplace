package com.localservices.controllers;

import com.localservices.models.Review;
import com.localservices.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review newReview = reviewService.createReview(review);
        return ResponseEntity.ok(newReview);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Review>> getReviewById(@PathVariable String id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return ResponseEntity.ok(review);
    }

    @GetMapping("/service/{serviceId}")
    public ResponseEntity<List<Review>> getReviewsByServiceId(@PathVariable String serviceId) {
        List<Review> reviews = reviewService.getReviewsByServiceId(serviceId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<Review>> getReviewsByProviderId(@PathVariable String providerId) {
        List<Review> reviews = reviewService.getReviewsByProviderId(providerId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Review>> getReviewsByCustomerId(@PathVariable String customerId) {
        List<Review> reviews = reviewService.getReviewsByCustomerId(customerId);
        return ResponseEntity.ok(reviews);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable String id, @RequestBody Review reviewDetails) {
        Review updatedReview = reviewService.updateReview(id, reviewDetails);
        return ResponseEntity.ok(updatedReview);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable String id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok("Review deleted successfully");
    }
}
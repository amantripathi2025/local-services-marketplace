package com.localservices.services;

import com.localservices.models.Review;
import com.localservices.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(Review review) {
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    public Optional<Review> getReviewById(String id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getReviewsByServiceId(String serviceId) {
        return reviewRepository.findByServiceId(serviceId);
    }

    public List<Review> getReviewsByProviderId(String providerId) {
        return reviewRepository.findByProviderId(providerId);
    }

    public List<Review> getReviewsByCustomerId(String customerId) {
        return reviewRepository.findByCustomerId(customerId);
    }

    public Review updateReview(String id, Review reviewDetails) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isPresent()) {
            Review existingReview = review.get();
            existingReview.setRating(reviewDetails.getRating());
            existingReview.setComment(reviewDetails.getComment());
            existingReview.setUpdatedAt(LocalDateTime.now());
            return reviewRepository.save(existingReview);
        }
        return null;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public void deleteReview(String id) {
        reviewRepository.deleteById(id);
    }
}
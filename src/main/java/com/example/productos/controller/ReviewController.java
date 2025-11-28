package com.example.productos.controller;

import com.example.productos.model.Review;
import com.example.productos.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @GetMapping
    public List<Review> getReviews(@RequestParam(required = false) String productId) {
        if (productId != null) {
            return reviewRepository.findByProductId(productId);
        }
        return reviewRepository.findAll();
    }
}
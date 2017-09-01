package com.mooovi.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mooovi.business.entity.Product;
import com.mooovi.business.entity.Review;
import com.mooovi.business.repository.ProductRepository;
import com.mooovi.business.repository.ReviewRepository;
import com.mooovi.business.service.ProductService;
import com.mooovi.business.service.ReviewService;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService{

    @Autowired 
    private ReviewRepository reviewRepository;
    
    
    
    @Autowired
    private ProductService productService;

    @Override
    public void save(Review review, Long productId) {
        review.setProduct(productService.findOne(productId));
        reviewRepository.save(review);
    }
    
  



}

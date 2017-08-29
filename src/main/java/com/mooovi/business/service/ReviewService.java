package com.mooovi.business.service;

import com.mooovi.business.entity.Review;

public interface ReviewService {
	
	 void save(Review review, Long productId, Long userId);

}

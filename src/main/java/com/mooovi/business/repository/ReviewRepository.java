package com.mooovi.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mooovi.business.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}

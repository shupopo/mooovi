package com.mooovi.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mooovi.business.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
    Product findByTitle(String title);

}

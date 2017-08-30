package com.mooovi.business.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mooovi.business.entity.Product;

public interface ProductService {
	
    Product save(Product product);
    
    Product findOneOrNew(String title);
    
    Page<Product> findAll(Pageable pageable);
    
    Product findOne(Long id);

}

package com.mooovi.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mooovi.business.entity.Product;
import com.mooovi.business.repository.ProductRepository;
import com.mooovi.business.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	   @Autowired
	    private ProductRepository productRepository;

	    @Override
	    public Product save(Product product){
	        return productRepository.save(product);
	    }

}

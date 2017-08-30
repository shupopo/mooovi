package com.mooovi.business.service;

import com.mooovi.business.entity.Product;

public interface ProductService {
	
    Product save(Product product);
    
    Product findOneOrNew(String title);

}

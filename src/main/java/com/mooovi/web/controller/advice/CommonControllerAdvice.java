package com.mooovi.web.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mooovi.business.entity.Product;
import com.mooovi.business.service.ProductService;

@ControllerAdvice
public class CommonControllerAdvice {

    @Autowired
    private ProductService productService;

    @ModelAttribute(name = "rankingProducts")
    private Page<Product> setupRankingProducts() {
        return productService.findTop5();
    }
}

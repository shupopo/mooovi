package com.mooovi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mooovi.business.entity.Product;
import com.mooovi.business.service.ProductService;

@Controller
public class TopController {

	 @Autowired
	    private ProductService productService;

	    @GetMapping("/")
	    public String index(Pageable pageable, Model model){
	        Page<Product> products = productService.findAll(pageable);
	        model.addAttribute("products", products);
	        return "top/index";
	    }
	    
	

}

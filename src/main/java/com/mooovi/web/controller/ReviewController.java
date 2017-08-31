package com.mooovi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mooovi.business.entity.Product;
import com.mooovi.business.service.ProductService;
import com.mooovi.web.form.ReviewForm;

//public class ReviewController {
//	
//	@Autowired
//    private ProductService productService;
//	
//	@GetMapping("/products/{productId}/reviews")
//    public String newReview(@PathVariable Long productId,  ReviewForm form,Model model){
//        Product product = productService.findOne(productId);
//		model.addAttribute("product", product);
//        return "reviews/new";
//    }
//
//}

@Controller
public class ReviewController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}/reviews")
    public String newReview(@PathVariable Long productId,
                            ReviewForm form,
                            Model model) {
        Product product = productService.findOne(productId);
        model.addAttribute("product", product);
        return "reviews/new";
    }

}

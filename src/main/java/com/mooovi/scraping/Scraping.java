package com.mooovi.scraping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mooovi.business.service.ProductService;

@Component
public class Scraping {

    @Autowired
    private ProductService productService;

    private static final String SITE_URL = "http://review-movie.herokuapp.com/";

    public void execute() throws IOException {
        System.out.println("execute scraping!");
    }

    private List<String> collectPageLink() throws IOException {
        return null;
    }

    private void saveProduct(String link) throws IOException {
    }

}

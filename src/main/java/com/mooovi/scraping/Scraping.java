package com.mooovi.scraping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mooovi.business.entity.Product;
import com.mooovi.business.service.ProductService;

@Component
public class Scraping {

    @Autowired
    private ProductService productService;

    private static final String SITE_URL = "http://review-movie.herokuapp.com";

    public void execute() throws IOException {
        List<String> links = collectPageLink();  
        for (String link : links) {  
            saveProduct(SITE_URL + link);  
        }
    }

    private List<String> collectPageLink() throws IOException {
        List<String> links = new ArrayList<>();
        Document document = Jsoup.connect(SITE_URL).get();
        Elements elements = document.select(".entry-title a");
        for (org.jsoup.nodes.Element element : elements) {
            links.add(element.attr("href"));
        }
        return links;
    }

    private void saveProduct(String link) throws IOException {
        Document document = Jsoup.connect(link).get();  
        String title = document.select(".entry-title").first().text();  
        String imageUrl = document.select(".entry-content img").first().attr("src");  

        Product product = new Product();  
        product.setTitle(title);  
        product.setImageUrl(imageUrl);  
        productService.save(product);  
    }

}
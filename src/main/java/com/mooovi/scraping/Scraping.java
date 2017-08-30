package com.mooovi.scraping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mooovi.business.entity.Product;
import com.mooovi.business.service.ProductService;

@Component
public class Scraping {

    @Autowired
    private ProductService productService;

    private static final String SITE_URL = "http://review-movie.herokuapp.com/";

    public void execute() throws IOException {
        List<String> links = collectPageLink();  
        for (String link : links) {  
            saveProduct(SITE_URL + link);  
        }
    }

    
//    private List collectPageLink() throws IOException {
//        List<String> links = new ArrayList<>();
//        String nextUrl = ""; // パスの部分を変数で定義
//        while (true) {
//            Document document = Jsoup.connect(SITE_URL + nextUrl).get();
//            Elements elements = document.select(".entry-title a");
//            for (Element element : elements) {
//                links.add(element.attr("href"));
//            }
//            Element nextLink = document.select(".pagenation .next a").first(); // 「次へ」を表すタグを取得
//            if (nextLink != null) {
//                // nextLinkがあればnextUrlを更新する
//            		nextUrl = nextLink.attr("href");
//            } else {
//                // nextLinkがなければwhileを抜ける
//            	break;
//            }
//        }
//        return links;
//    }

    
    private List<String> collectPageLink() throws IOException {
        List<String> links = new ArrayList<>();
        String nextUrl = "";  // ①
        while (true) {  // ②
            Document document = Jsoup.connect(SITE_URL + nextUrl).get();  // ③
            Elements elements = document.select(".entry-title a");
            for (Element element : elements) {
                links.add(element.attr("href"));
            }
            Element nextLink = document.select(".pagination .next a").first();  // ④
            if (nextLink != null) {  // ⑤
                nextUrl = nextLink.attr("href");  // ⑥
            } else {
                break;  // ⑦
            }
        }
        return links;
    }
    private void saveProduct(String link) throws IOException {
        Document document = Jsoup.connect(link).get();  
        String title = document.select(".entry-title").first().text();  
        String imageUrl = document.select(".entry-content img").first().attr("src");  

        Product product = productService.findOneOrNew(title); 
        product.setTitle(title);  
        product.setImageUrl(imageUrl);  
        productService.save(product);  
    }

}
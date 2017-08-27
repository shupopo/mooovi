package com.mooovi.scraping.practice;

import java.io.IOException;

import javax.lang.model.element.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;


public class ScrapingTitle {

    public static void main(String[] args){
        try {
            scraping();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void scraping() throws IOException {
    	
    	Document document = Jsoup.connect("http://review-movie.herokuapp.com/").get();  // ①
        Elements elements = document.select(".entry-title a");  // ②
        for(org.jsoup.nodes.Element element : elements){  // ③
            System.out.println(element.text());  // ④
        }
    }

}

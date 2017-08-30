package com.mooovi.scraping.practice;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapingPractice {

    public static void main(String[] args){
        try {
            scraping();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void scraping() throws IOException {
    	 	Document document = Jsoup.connect("https://app-mooovi.herokuapp.com/works/initial_scraping").get();
    	    Elements elements = document.select("p");
    	    for(Element element : elements){
    	        System.out.println(element.text());
    	    }
    }

}

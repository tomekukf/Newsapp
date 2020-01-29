package com.tomek.domanski.controllers;

import com.tomek.domanski.interfaces.INewsService;
import com.tomek.domanski.model.News;
import com.tomek.domanski.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NewsConroller {

    private final NewsService newsService;

    @Autowired
    public NewsConroller(NewsService newsService) {
        this.newsService = newsService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/news/{country}/{category}")
    public ResponseEntity<News> getNews(@PathVariable("country") String country, @PathVariable("category") String category){

        News listOfNews;
        try {
            listOfNews = newsService.getListOfNews(country, category);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new News(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listOfNews, HttpStatus.OK);
    }

    @RequestMapping("/api")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<News> getNewsTest(){
        return new ResponseEntity<>(new News(), HttpStatus.NOT_FOUND);
    }
}

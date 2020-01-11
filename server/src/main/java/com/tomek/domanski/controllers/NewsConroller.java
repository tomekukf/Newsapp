package com.tomek.domanski.controllers;

import com.tomek.domanski.model.Article;
import com.tomek.domanski.model.News;
import com.tomek.domanski.services.NewsService;
import com.tomek.domanski.wrappers.NewsWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController

public class NewsConroller {

    @Autowired
    private NewsService newsService;

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
}

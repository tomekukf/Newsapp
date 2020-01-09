package com.tomek.domanski.controllers;

import com.tomek.domanski.model.Article;
import com.tomek.domanski.model.News;
import com.tomek.domanski.services.NewsService;
import com.tomek.domanski.wrappers.NewsWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController

public class NewsConroller {

    @RequestMapping("/greeting")
    public Article greeting() {
        return new Article("title","desc",new Date(),"soruceName","url1","url2");
    }



    @Autowired
    private NewsService newsService;



    @RequestMapping("/news/{country}/{category}")
    public News getNewses(@PathVariable("country") String country, @PathVariable("category") String category) {

        System.out.println(country);
        System.out.println(category);

        News listOfNews = newsService.getListOfNews(country, category);


//        System.out.println(forObject.toString());
//        forObject.getArticles().stream().forEach(elem-> System.out.println(elem));
        return listOfNews;
    }

//    private static void getEmployeeById()
//    {
//        final String uri = "http://localhost:8080/springrestexample/employees/{id}";
//
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("id", "1");
//
//        RestTemplate restTemplate = new RestTemplate();
//        EmployeeVO result = restTemplate.getForObject(uri, EmployeeVO.class, params);
//
//        System.out.println(result);
//    }






//    https://newsapi.org/v2/top-headlines?apiKey=83c71a7e35b64f538d32693bb230d20c&country=pl&category=technology
}

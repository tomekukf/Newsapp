package com.tomek.domanski.services;


import com.tomek.domanski.model.Article;
import com.tomek.domanski.model.News;
import com.tomek.domanski.wrappers.NewsWrapper;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {


    private static final String URL = "https://newsapi.org/v2/top-headlines";
//            ?apiKey=83c71a7e35b64f538d32693bb230d20c&country={country}&category={category}";

    @Autowired
    RestTemplate restTemplate;

    @Value("${apiKey}")
    private String apiKey;


    UriComponents u1ri = UriComponentsBuilder
            .fromHttpUrl("http://localhost:8585/app/image/{apiKey}")
            .buildAndExpand(apiKey);


    public News getListOfNews(String country, String category) {

        System.out.println(apiKey);
        String uri = "https://newsapi.org/v2/top-headlines?apiKey=83c71a7e35b64f538d32693bb230d20c&country={country}&category={category}";

//        Map<String, String> params = new HashMap<>();
//        params.put("country", country);
//        params.put("category", category);


        URL url;
        NewsWrapper newsWrapper = null;
        try {
            url = getUrl(country, category);
            System.out.println(url);
            newsWrapper = restTemplate.getForObject(url.toString(), NewsWrapper.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


//        System.out.println(url);

        System.out.println(u1ri.toString());
//        restTemplate.getForEntity()
//        NewsWrapper forObject = restTemplate.getForObject(url, NewsWrapper.class, params);


        List<Article> articles = newsWrapper.getArticles().stream().map(elem -> new Article(elem.getTitle(), elem.getDescription(), new Date(), elem.getSource().getName(), elem.getUrl(), elem.getUrlToImage())).collect(Collectors.toList());

        News news = new News(country,category,articles);

//        return null;
        return news;
    }

    private URL getUrl(String country, String category) throws URISyntaxException, MalformedURLException {

        URIBuilder b = new URIBuilder(URL);
        b.addParameter("apiKey", apiKey);
        b.addParameter("country", country);
        b.addParameter("category", category);

        return b.build().toURL();


//        URL url;
//        try {
//            b = new URIBuilder("http://example.com");
//            b.addParameter("t", "search");
//            b.addParameter("q", "apples");
//             url = b.build().toURL();
//            System.out.println(url.toString());
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

    }
}

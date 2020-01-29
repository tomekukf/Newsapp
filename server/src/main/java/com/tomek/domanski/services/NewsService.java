package com.tomek.domanski.services;


import com.tomek.domanski.exceptions.DataNotFoundException;
import com.tomek.domanski.interfaces.INewsService;
import com.tomek.domanski.model.Article;
import com.tomek.domanski.model.News;
import com.tomek.domanski.wrappers.ArticleWrapper;
import com.tomek.domanski.wrappers.NewsWrapper;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class NewsService implements INewsService {


    private static final String URL = "https://newsapi.org/v2/top-headlines";
    private static final String DATE_FROMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    @Autowired
    RestTemplate restTemplate;

    @Value("${apiKey}")
    private String apiKey;

    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);


    public News getListOfNews(String country, String category) throws Exception {

        System.out.println(getUrl(country, category));
        NewsWrapper newsWrapper = restTemplate.getForObject(getUrl(country, category), NewsWrapper.class);

        if (newsWrapper != null) {
            return new News(country, category, getArticles(newsWrapper));
        } else {
            throw new DataNotFoundException();
        }

    }

    private String getUrl(String country, String category) {

        URL url = null;
        try {
            url = prepareApiUrlRequest(country, category);

        } catch (URISyntaxException e) {
            logger.info("URISyntaxException " + e.getMessage());
            e.printStackTrace();
        } catch (MalformedURLException e) {
            logger.info("MalformedURLException " + e.getMessage());
            e.printStackTrace();
        }
        return url.toString();
    }

    private List<Article> getArticles(NewsWrapper newsWrapper) throws Exception {

        //Sort ArticleWrapper before extraction
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FROMAT);
        newsWrapper.getArticles().sort(Comparator.comparing((ArticleWrapper s) -> LocalDateTime.parse(s.getPublishedAt(), formatter)).reversed());

        List<Article> articles = new ArrayList<>();
        for (ArticleWrapper elem : newsWrapper.getArticles()) {
            Article article = new Article(
                    elem.getAuthor(),
                    elem.getTitle(),
                    elem.getDescription(),
                    getParsedDate(elem.getPublishedAt()),
                    elem.getSource().getName(),
                    elem.getUrl(),
                    elem.getUrlToImage());
            articles.add(article);
        }
        return articles;
    }

    private String getParsedDate(String publishedAt) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FROMAT);
        Date dateToParse = simpleDateFormat.parse(publishedAt);
        return new SimpleDateFormat("yyyy-MM-dd").format(dateToParse);
    }


    private URL prepareApiUrlRequest(String country, String category) throws URISyntaxException, MalformedURLException {
        URIBuilder uriBuilder = new URIBuilder(URL);
        uriBuilder.addParameter("apiKey", apiKey);
        uriBuilder.addParameter("country", country);
        uriBuilder.addParameter("category", category);
        return uriBuilder.build().toURL();


    }
}

package com.tomek.domanski.wrappers;

import lombok.*;


@Data
public class ArticleWrapper {

    private Source source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

}

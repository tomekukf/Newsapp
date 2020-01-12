package com.tomek.domanski.wrappers;

import lombok.*;

import java.util.List;

@Data
public class NewsWrapper {

    private String status;
    private int  totalResults;
    private List<ArticleWrapper> articles;
}

package com.tomek.domanski.wrappers;

import com.tomek.domanski.model.Article;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewsWrapper {

    private String status;
    private int  totalResults;
    private List<ArticleWrapper> articlesWrappers;
}

package com.tomek.domanski.interfaces;

import com.tomek.domanski.model.News;

public interface INewsService {
    News getListOfNews(String country, String category) throws Exception;
}


package com.tomek.domanski.model;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

    private String country;
    private String category;
    private List<Article> articles;


}

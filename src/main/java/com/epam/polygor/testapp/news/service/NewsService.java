package com.epam.polygor.testapp.news.service;


import com.epam.polygor.testapp.news.model.News;

import java.util.List;

public interface NewsService {

    News save(News news);

    void edit (News news);

    void delete(News news);

    News findByTitle(String title);

    List<News> getAllNews();

    News fetchById(Integer id);

    boolean isNewsAlreadyCreated(String title);

}

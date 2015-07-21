package com.epam.polygor.testapp.news.database;


import com.epam.polygor.testapp.news.model.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Integer> {
    News findByTitle(String title);
}

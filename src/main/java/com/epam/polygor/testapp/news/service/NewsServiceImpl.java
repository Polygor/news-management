package com.epam.polygor.testapp.news.service;

import com.epam.polygor.testapp.news.database.NewsRepository;
import com.epam.polygor.testapp.news.model.News;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
    private NewsRepository newsRepository;

    //constructor
    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News save(News news) {
        String title = news.getTitle();
        if (isNewsAlreadyCreated(title)) {
            throw new ServiceException("News with such title have been already created");
        }
        return newsRepository.save(news);
    }


    @Override
    @Transactional
    public void edit(News news) {
        newsRepository.save(news);
    }


    @Override
    @Transactional
    public void delete(News news) {newsRepository.delete(news.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public News findByTitle(String title) {
        return newsRepository.findByTitle(title);
    }

    @Override
    public List<News> getAllNews() {
        return Lists.newArrayList(newsRepository.findAll());
    }

    @Override
    public News fetchById(Integer id) {
        return newsRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
        public boolean isNewsAlreadyCreated (String title){
            return findByTitle(title) != null;
        }
    }


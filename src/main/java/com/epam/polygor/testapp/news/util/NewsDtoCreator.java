package com.epam.polygor.testapp.news.util;


import com.epam.polygor.testapp.news.model.News;
import com.epam.polygor.testapp.news.model.dto.NewsDto;

import java.sql.Date;
import java.text.ParseException;

public class NewsDtoCreator {

    public static News buildNewsEntityFromNewsDto(NewsDto newsDto) throws ParseException {
        if (newsDto == null) return null;
        News news = new News();
        news.setId(newsDto.getId());
        String postingDate = newsDto.getPostingDate();
        news.setPostingDate(Date.valueOf(postingDate));
        news.setBrief(newsDto.getBrief());
        news.setContent(newsDto.getContent());
        news.setTitle(newsDto.getTitle());
        return news;
    }

    public static NewsDto buildNewsDtoFromNewsEntity(News news) throws ParseException {
        if (news == null) return null;
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        Date postingDate = news.getPostingDate();
        newsDto.setPostingDate(String.valueOf(postingDate));
        newsDto.setBrief(news.getBrief());
        newsDto.setContent(news.getContent());
        newsDto.setTitle(news.getTitle());
        return newsDto;
    }
}



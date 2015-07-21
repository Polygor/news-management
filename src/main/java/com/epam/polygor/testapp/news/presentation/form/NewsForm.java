package com.epam.polygor.testapp.news.presentation.form;



import com.epam.polygor.testapp.news.model.dto.NewsDto;
import org.apache.struts.validator.ValidatorForm;

public class NewsForm extends ValidatorForm {

    private NewsDto news;

    public NewsDto getNews() {
        if (this.news == null) {
            setNews(new NewsDto());
        }
        return this.news;
    }

    public void setNews(NewsDto news) {
        this.news = news;
    }
}

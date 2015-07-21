package com.epam.polygor.testapp.news.model;


import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEWS_ID_SEQ")
    @SequenceGenerator(name="NEWS_ID_SEQ", sequenceName = "NEWS_ID_SEQ")
    private Integer id;
    private String title;
    private String brief;
    private String content;
    @Type(type = "java.sql.Date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date postingDate;

    public News(String title, String brief, String content, Date postingDate) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.postingDate = postingDate;
    }

    public News() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", postingDate=" + postingDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;

        News news = (News) o;

        if (brief != null ? !brief.equals(news.brief) : news.brief != null) return false;
        if (content != null ? !content.equals(news.content) : news.content != null) return false;
        if (id != null ? !id.equals(news.id) : news.id != null) return false;
        if (postingDate != null ? !postingDate.equals(news.postingDate) : news.postingDate != null) return false;
        if (title != null ? !title.equals(news.title) : news.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (postingDate != null ? postingDate.hashCode() : 0);
        return result;
    }
}

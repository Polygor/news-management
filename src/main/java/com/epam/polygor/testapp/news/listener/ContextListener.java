package com.epam.polygor.testapp.news.listener;

import com.epam.polygor.testapp.news.model.News;
import com.epam.polygor.testapp.news.service.NewsService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.CopyOnWriteArrayList;
import static com.epam.polygor.testapp.news.database.SpringApplicationContext.getInstance;

@WebListener
public class ContextListener implements ServletContextListener {
    public static final ApplicationContext contextInstance = getInstance();
    private NewsService newsService = (NewsService) contextInstance.getBean("newsService");
    public static final String NEWS = "newsList";
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(NEWS, new CopyOnWriteArrayList<>(newsService.getAllNews()));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}


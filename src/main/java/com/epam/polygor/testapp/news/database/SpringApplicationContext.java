package com.epam.polygor.testapp.news.database;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContext {

    public static ApplicationContext getInstance() {
        return InstanceHolder.instance;
    }

    private static class InstanceHolder {
        private static ApplicationContext instance = new ClassPathXmlApplicationContext("bean.xml");
    }
}
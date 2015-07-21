package com.epam.polygor.testapp.news.presentation.action;

import com.epam.polygor.testapp.news.model.News;
import com.epam.polygor.testapp.news.model.dto.NewsDto;
import com.epam.polygor.testapp.news.presentation.form.NewsForm;
import com.epam.polygor.testapp.news.service.NewsService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.epam.polygor.testapp.news.database.SpringApplicationContext.getInstance;
import static com.epam.polygor.testapp.news.util.NewsDtoCreator.buildNewsDtoFromNewsEntity;

public class PageNavigationAction extends DispatchAction {
    public static final ApplicationContext contextInstance = getInstance();
    private final static String SUCCESS = "success";
    private final static String ERROR = "error";
    private static final String NEWS_LIST = "newsList";
    private static final String NEWS_MAIN_PAGE = "news-list";
    private static final String SHOW_CREATE_NEWS = "show-create-news";
    private static final String SHOW_EDIT_NEWS = "show-edit-news";
    private static final String SHOW_OBSERVE_NEWS = "show-observe-news";
    private static final String NEWS_ID = "id";
    private NewsService newsService = (NewsService) contextInstance.getBean("newsService");

    public ActionForward showListAction(ActionMapping mapping, ActionForm form,
                                        HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<News> newsList = newsService.getAllNews();
            request.setAttribute(NEWS_LIST, newsList);
            return mapping.findForward(SUCCESS);
        } catch (Exception e) {
            return mapping.findForward(ERROR);
        }
    }

    public ActionForward showAddNewsAction(ActionMapping mapping, ActionForm form,
                                           HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<News> newsList = newsService.getAllNews();
            request.setAttribute(NEWS_LIST, newsList);
            return mapping.findForward(SHOW_CREATE_NEWS);
        } catch (Exception e) {
            return mapping.findForward(ERROR);
        }
    }


    public ActionForward showEditNewsAction(ActionMapping mapping, ActionForm form,
                                            HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            NewsForm newsForm = (NewsForm) form;
            String newsId = request.getParameter(NEWS_ID);
            if (newsId != null) {
                News news = newsService.fetchById(Integer.valueOf(newsId));
                NewsDto newsDto = buildNewsDtoFromNewsEntity(news);
                newsForm.setNews(newsDto);
            }
            return mapping.findForward(SHOW_EDIT_NEWS);
        } catch (Exception e) {
            return mapping.findForward(ERROR);
        }
    }

    public ActionForward showNewsAction(ActionMapping mapping, ActionForm form,
                                        HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String newsId = request.getParameter(NEWS_ID);
            News news = newsService.fetchById(Integer.valueOf(newsId));
            NewsForm newsForm = (NewsForm) form;
            NewsDto newsDto = buildNewsDtoFromNewsEntity(news);
            newsForm.setNews(newsDto);
            return mapping.findForward(SHOW_OBSERVE_NEWS);
        } catch (Exception e) {
            return mapping.findForward(ERROR);
        }
    }

    public ActionForward showNewsListAction(ActionMapping mapping, ActionForm form,
                                            HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward(NEWS_MAIN_PAGE);
    }
}


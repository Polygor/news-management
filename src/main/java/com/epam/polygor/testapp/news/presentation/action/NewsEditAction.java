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

import static com.epam.polygor.testapp.news.database.SpringApplicationContext.getInstance;
import static com.epam.polygor.testapp.news.util.NewsDtoCreator.buildNewsEntityFromNewsDto;

public class NewsEditAction extends DispatchAction {
    private static final String NEWS_LIST = "news-list";
    private static final String PARAMETERS = "Cb001";
    public static final ApplicationContext contextInstance = getInstance();
    private NewsService newsService = (NewsService) contextInstance.getBean("newsService");

    public ActionForward editAction(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        News news = buildNewsEntityFromNewsDto(newsForm.getNews());
        newsService.edit(news);
        return mapping.findForward(NEWS_LIST);
    }

    public ActionForward deleteAction(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        NewsDto newsDto = newsForm.getNews();
        News news = buildNewsEntityFromNewsDto(newsDto);
        newsService.delete(news);
        return mapping.findForward(NEWS_LIST);
    }

    public ActionForward deleteListAction(ActionMapping mapping, ActionForm form,
                                          HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] newsIdArray = request.getParameterValues(PARAMETERS);
        if (newsIdArray == null) {
            return mapping.findForward(NEWS_LIST);
        }
        for (String id : newsIdArray) {
            News news = newsService.fetchById(Integer.valueOf(id));
            newsService.delete(news);
        }
        return mapping.findForward(NEWS_LIST);
    }

    public ActionForward saveAction(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        News news = buildNewsEntityFromNewsDto(newsForm.getNews());
        newsService.save(news);
        return mapping.findForward(NEWS_LIST);
    }
}

package com.epam.polygor.testapp.news.presentation.action;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class ChangeLanguageAction extends DispatchAction {
    public static final String SUCCESS = "success";
    public static final String LOCALE_RU = "ru";

    public ActionForward russian(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute(Globals.LOCALE_KEY, new Locale(LOCALE_RU));
        return mapping.findForward(SUCCESS);
    }

    public ActionForward english(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
        return mapping.findForward(SUCCESS);
    }
}


package com.epam.polygor.testapp.news.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ErrorHandler", urlPatterns = "/error")
public class ErrorHandler extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);
    private static final String STATUS_CODE = "javax.servlet.error.status_code";
    private static final String EXCEPTION = "javax.servlet.error.exception";
    private static final String SERVLET_NAME ="javax.servlet.error.servlet_name";
    private static final String UNKNOWN = "Unknown";
    private static final String REQUEST_URI = "javax.servlet.error.request_uri";
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer statusCode = (Integer)
                req.getAttribute(STATUS_CODE);
        Throwable throwable = (Throwable)
                req.getAttribute(EXCEPTION);
        String servletName = (String)
                req.getAttribute(SERVLET_NAME);
        if (servletName == null){
            servletName = UNKNOWN;
        }
        String requestUri = (String)
                req.getAttribute(REQUEST_URI);
        if (requestUri == null){
            requestUri = UNKNOWN;
        }

        LOGGER.error("error on servlet {} errorStatus {} and requestUri: {}", servletName, statusCode, requestUri, throwable);
        req.getRequestDispatcher("/error.jsp").forward(req, resp);
    }
}

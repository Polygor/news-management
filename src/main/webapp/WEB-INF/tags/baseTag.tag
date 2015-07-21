<%@ tag description="authentication template" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html>
<head>
    <title><bean:message key="news.management"/></title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="static/css/style.css">
    <script src="static/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/show.do?method=showListAction"/>"><bean:message key="news.management"/></a>
        </div>
        <div class="div-right-language">
            <html:link styleClass="navbar-brand float-right" page="/locale.do?method=english">English</html:link>
            <html:link styleClass="navbar-brand float-right" page="/locale.do?method=russian">Русский</html:link>
        </div>
    </div>
</nav>
<div class="div-left panel panel-default">
    <div class="panel panel-default margin-1perc">
        <div class="panel-heading text-align-center">
            <b><bean:message key="news"/></b>
        </div>
        <div class="panel-body text-align-center">
            <img src="static/img/setting-icon.png" width="20" height="20">&nbsp;
            <html:link page="/show.do?method=showListAction"><bean:message key="news.list"/></html:link>
            <br/>
            &nbsp;<img src="/static/img/setting-icon.png" width="20" height="20">&nbsp;
            <html:link page="/show.do?method=showAddNewsAction"><bean:message key="add.news"/></html:link>
        </div>
    </div>
</div>
<div class="div-right panel panel-default">
    <jsp:doBody/>
</div>
<div id="footer">
    <p class="p-center">Copyright &copy; EPAM 2015. Polygor. All rights reserved.</p>
</div>
</body>
</html>
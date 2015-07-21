<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:baseTag>
    <html:form action="/news.do?method=deleteListAction">
        <p class="p-left"><a><html:link page="/show.do?method=showListAction"><bean:message key="news"/></html:link></a>
            <bean:message key="news.list"/></p>
        <c:forEach items="${newsList}" var="news">
            <div class="panel panel-default margin-1perc">
                <div class="panel-heading">
                    <label for="Lbl002"><p id="Lbl002">${news.title}</p></label>

                    <p class="float-right">${news.postingDate}</p>
                </div>
                <div class="panel-body">
                        ${news.content}
                    <div class="float-right">
                        <a class="btn" href="<c:url value="/show.do?method=showNewsAction&id=${news.id}"/>">
                            <bean:message key="view"/>
                        </a>
                        <a href="<c:url value="/show.do?method=showEditNewsAction"/>" class="btn"
                           name="Lnk002"><bean:message key="edit"/></a>
                        <label for="Select"></label><input type="checkbox" name="Cb001" id="Select" value="${news.id}"/>
                    </div>
                </div>
            </div>
        </c:forEach>
        <c:choose>
            <c:when test="${not empty newsList}">
                <div class="float-right margin-right">
                    <html:submit styleClass="btn-default"><bean:message key="delete"/></html:submit>
                </div>
            </c:when>
            <c:otherwise><h1 align="center"><bean:message key="news.list.is.empty"/></h1></c:otherwise>
        </c:choose>
    </html:form>
</t:baseTag>

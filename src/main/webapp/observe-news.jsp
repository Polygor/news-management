<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:baseTag>
    <p class="p-left"><a><bean:message key="news"/></a> >> <bean:message key="news.view"/></p>

    <div class="margin-1perc">
        <table class="table">
            <tr>
                <td><bean:message key="news.title"/></td>
                <td><bean:write name="NewsForm" property="news.title"/></td>
            </tr>
            <tr>
                <td><bean:message key="news.date"/></td>
                <td><bean:write name="NewsForm" property="news.postingDate"/></td>
            </tr>
            <tr>
                <td><bean:message key="brief"/></td>
                <td><bean:write name="NewsForm" property="news.brief"/></td>
            </tr>
            <tr>
                <td><bean:message key="content"/></td>
                <td><bean:write name="NewsForm" property="news.content"/></td>
            </tr>
        </table>
        <div class="float-right">
            <html:form action="show.do?method=showEditNewsAction">
                <div class="test-block1">
                    <html:submit styleClass="btn btn-default"><bean:message key="edit.upper.case"/></html:submit>
                </div>
            </html:form>
            <html:form action="news.do?method=deleteAction">
                <div class="test-block2 float-right">
                    <html:submit styleClass="btn btn-default"><bean:message key="cancel"/></html:submit>
                </div>
            </html:form>
        </div>
    </div>
</t:baseTag>
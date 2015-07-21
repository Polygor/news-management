<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:baseTag>
    <p class="p-left"><html:link page="/show.do?method=showListAction"><bean:message key="news"/></html:link> >>
        <bean:message key="add.news"/></p>

    <html:form action="/create-news.do?method=saveAction">
        <div class="margin-1perc">
        <font color="red">
            <html:errors/>
        </font>
        <table class="table">
            <tr>
                <td><label for="Title"><bean:message key="news.title"/></label></td>
                <td>
                    <html:text name="NewsForm" property="news.title" maxlength="100"/>
                </td>
            </tr>
            <tr>
                <td><label for="Date"><bean:message key="news.date"/></label></td>
                <td>
                    <html:text name="NewsForm" property="news.postingDate" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td><label for="Brief"><bean:message key="brief"/></label></td>
                <td>
                    <html:textarea name="NewsForm" property="news.brief"/>
                </td>
            </tr>
            <tr>
                <td><label for="Content"><bean:message key="content"/></label></td>
                <td>
                    <html:textarea name="NewsForm" property="news.content"/>
                </td>
            </tr>
        </table>
        <div class="float-right">
        <div class="test-block1">
            <html:submit styleClass="btn btn-default"><bean:message key="save"/></html:submit>
        </div>
    </html:form>
    <html:form action="show.do?method=showNewsListAction">
        <div class="test-block2 float-right">
            <html:submit styleClass="btn btn-default"><bean:message key="cancel"/></html:submit>
        </div>
    </html:form>
    </div>
    </div>
</t:baseTag>
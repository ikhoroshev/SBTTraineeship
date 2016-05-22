<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 19.05.2016
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>TestChapter list</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <form:form modelAttribute="testChapter" action="/testapp/chapters/addTestChapter" method="POST" class="form-horizontal"
               id="search-testChapter-form">
        <div class="form-group has-feedback">
            <div>
                <label for="title">Title </label>
                <form:input class="form-control" path="title" size="30" maxlength="50" id="title"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>
            <div>
                <label for="position">Position </label>
                <form:input class="form-control" type="number"  min="0" max="5000" path="position" size="30" maxlength="50" id="position"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>
            <div>
                <button class="btn btn-default" type="submit">Add chapter</button>
                <a class="btn btn-default" href='<spring:url value="/chapters/testChapterList" htmlEscape="true"/>'>View TestChapter</a>
            </div>
        </div>

    </form:form>
</div>
</body>
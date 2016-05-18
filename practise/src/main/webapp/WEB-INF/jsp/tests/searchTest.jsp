<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 17.05.2016
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<title>Search Test</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <spring:url value="/search" var="findTest"/>
    <form:form modelAttribute="test" action="${findTest}" method="post" class="form-horizontal"
    id="search-test-form">
        <div>
            <label for="Title">Title </label>
            <form:input class="form-control" path="Title" size="30" maxlength="80" id="Title"/>
            <span class="help-inline"><form:errors path="*"/></span>
        </div>

        <div>
            <label for="Description">Description </label>
            <form:input class="form-control" path="Description" size="30" maxlength="80" id="Description"/>
            <span class="help-inline " ><form:errors path="*"/></span>
        </div>


        <button class="btn btn-default" type="submit">Search test </button>
        <a class="btn btn-default" href='<spring:url value="/tests/add" htmlEscape="true"/>'>Add Test</a>

        <c:if test="${searchResult != null}">
            <table class="table table-stripped">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="test" items="${searchResult}">
                    <tr>
                        <td><c:out value="${test.title} "/></td>
                        <td>
                            <c:out value="${test.description}"/>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </form:form>

</div>
</body>
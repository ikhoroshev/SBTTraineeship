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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/testapp/resources/css/main.css" type="text/css"/>
<title>Search Test</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <spring:url value="/tests/search" var="findTest"/>
    <form:form modelAttribute="test" action="${findTest}" method="POST" class="form-horizontal"
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
    </form:form>
        <c:if test="${searchResult != null}">
            <%--<button class="btn btn-default" type="submit">Delete the marked </button>--%>
            <table class="table table-stripped">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Check for remove</th>
                </tr>
                </thead>
                <tbody>
                <form:form method="post" action="${pageContext.request.contextPath}/tests/del" modelAttribute="TestForm">
                    <c:forEach var="test" items="${searchResult}">
                        <tr>
                            <td><c:out value="${test.title} "/></td>
                            <td>
                                <c:out value="${test.description}"/>
                            </td>
                            <td>
                                <label>
                                    <%--<input type="checkbox"  name="${test.id}" value="TRUE">--%>
                                    <a class="btn btn-default" href='<spring:url value="/tests/delete/${test.id}"/>'>Delete</a>
                                </label>
                            </td>
                        </tr>
                    </c:forEach>

                </form:form>
                    </tbody>
                </table>

            <p class="error"> ${isError} </p>
        </c:if>


</div>
</body>
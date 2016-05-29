<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 29.05.2016
  Time: 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List tests</title>
</head>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>

<div class="container xd-container">

    <c:if test="${searchResult != null}">
        <%--<button class="btn btn-default" type="submit">Delete the marked </button>--%>
        <table class="table table-stripped">
            <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Статус</th>
                <th>Пройти</th>
            </tr>
            </thead>
            <tbody>
            <form:form method="post" action="${pageContext.request.contextPath}/tests/del" modelAttribute="TestForm">
                <c:forEach var="test" items="${searchResult}">
                    <tr>
                        <td><c:out value="${test.getTest().getTitle() } "/></td>
                        <td>
                            <c:out value="${test.getTest().getDescription()}"/>
                        </td>
                        <td><c:out value="${test.getStatus() } "/></td>
                        <td>
                            <label>
                                    <%--<input type="checkbox"  name="${test.id}" value="TRUE">--%>
                                <a class="btn btn-default" href='<spring:url value="/testRun/${test.id}"/>'>RUN</a>
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
</html>

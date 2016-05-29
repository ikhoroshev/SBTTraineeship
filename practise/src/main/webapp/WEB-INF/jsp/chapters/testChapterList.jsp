<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 19.05.2016
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test Chapter list</title>
    <jsp:include page="../header.jsp"/>
</head>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <table class="table table-stripped">
        <thead>
        <tr>
            <th>Title</th>
            <th>Position</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="testChapter" items="${allTestChapter}">
            <tr>
                <td><c:out value="${testChapter.title}"/></td>
                <td><c:out value="${testChapter.position}"/></td>
                <td>
                    <a class="btn btn-default" href='<spring:url value="/testChapter/delete/${testChapter.id}" htmlEscape="true"/>'>Delete <c:if test="${testChapterId == testChapter.id}">
                        <c:out value="${noDelete}"/>
                    </c:if></a>
                    <a class="btn bt btn-default" href='<spring:url value="/testChapter/edit/${testChapter.id}"/>'>Edit<c:if test="${testChapterId == testChapter.id}">
                    </c:if></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <a class="btn btn-default" href='<spring:url value="/chapters/find" htmlEscape="true"/>'>Cancel</a>
    </table>
</div>
</body>
</html>

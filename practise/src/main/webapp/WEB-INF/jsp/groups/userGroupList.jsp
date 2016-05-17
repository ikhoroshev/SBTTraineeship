<%--
  Created by IntelliJ IDEA.
  User: Николай
  Date: 17.05.2016
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User group list</title>
    <jsp:include page="../header.jsp"/>
</head>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
<table class="table table-stripped">
    <thead>
    <tr>
        <th>Name</th>
        <th>Group type</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="group" items="${allUserGroup}">
        <tr>
            <td><c:out value="${group.name}"/></td>
            <td><c:out value="${group.type}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>

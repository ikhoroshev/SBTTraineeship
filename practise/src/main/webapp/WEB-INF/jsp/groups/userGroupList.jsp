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
    <a class="btn btn-default" href='<spring:url value="/groups/addForm" htmlEscape="true"/>'>Add group</a>
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

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Test List</title>
<jsp:include page="../header.jsp"/>

<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <table class="table table-stripped">
        <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tests" items="${allTest}">
            <tr>
                <td><c:out value="${tests.title}"/></td>
                <td><c:out value="${tests.description}"/></td>
            <td>
                <a class="btn btn-default" href='<spring:url value="/test/delete/${test.id}" htmlEscape="true"/>'>Delete</a>
            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>

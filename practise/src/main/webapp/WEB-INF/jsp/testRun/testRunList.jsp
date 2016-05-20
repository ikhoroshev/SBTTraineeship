<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test run list</title>
    <jsp:include page="../header.jsp"/>
</head>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <table class="table table-stripped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Group</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.lastName} ${user.middleName} ${user.firstName} </td>
            <td>${user.group.name} ${user.group.type}</td>
        </tr>
        </tbody>
    </table>
    <hr/>

    <table class="table table-stripped">
        <thead>
        <tr>
            <th>Test</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="testrun" items="${testRuns}">
            <tr>
                <td><c:out value="${testrun.test.title}"/></td>
                <td><c:out value="${testrun.testRunStatus}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

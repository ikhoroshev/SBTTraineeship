<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User test</title>
    <jsp:include page="../header.jsp"/>
</head>
<body>
    <jsp:include page="../navigation.jsp"/>
    <div class="container xd-container">
        <div>
            <label>Title </label><br>
            <c:out value="${test.title}" />
        </div>
        <hr>
        <div>
            <label>Description</label><br>
            <c:out value="${test.description}"/>
        </div>
        <hr>
        <div>
            <a class="btn btn-default" href='<spring:url value="/userTest/next?id=" htmlEscape="true"/>'>Start test</a>
        </div>
    </div>
</body>
</html>
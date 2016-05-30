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
    <h1>Stop</h1>
    <a class="btn btn-default" href='<spring:url value="/viewResult?userId=${user.id}&testRunId=${testRun}" htmlEscape="true"/>'>Open Result</a>

</div>
</body>
</html>

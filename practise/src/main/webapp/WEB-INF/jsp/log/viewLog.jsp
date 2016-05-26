<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Log list</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
        <div>
            <a class="btn btn-default" href='<spring:url value="/" htmlEscape="true"/>'>Index Page</a>
        </div>
            <table class="table table-stripped">
                <thead>
                <tr>
                    <th>Date</th>
                    <th>User</th>
                    <th>Code</th>
                    <th>Message</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="log" items="${systemLogs}">
                    <tr>
                        <td><c:out value="${log.dateTime}"/></td>
                        <td>[<c:out value="${log.user.username}"/>]<br>
                            <c:out value="${log.user.lastName}"/><br>
                            <c:out value="${log.user.firstName}"/><br>
                            <c:out value="${log.user.middleName}"/><br>
                        </td>
                        <td><c:out value="${log.code}"/></td>
                        <td><c:out value="${log.message}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
</div>
</body>
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
                    <th style="text-align: center">Date</th>
                    <th style="text-align: center">User</th>
                    <th style="text-align: center">Code</th>
                    <th style="text-align: center">Message</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="log" items="${systemLogs}">
                    <tr>
                        <td style="vertical-align: middle; text-align: center; max-width: 100px; width: 100px"><c:out value="${log.dateTime}"/></td>
                        <td style="vertical-align: middle; text-align: center;">
                            <c:if test="${log.user!=null}">
                                [<c:out value="${log.user.username}"/>]<br>
                            </c:if>

                            <c:out value="${log.user.lastName}"/><br>
                            <c:out value="${log.user.firstName}"/><br>
                            <c:out value="${log.user.middleName}"/><br>
                        </td>
                        <td style="vertical-align: middle; text-align: center; max-width: 100px; width: 100px"><c:out value="${log.code}"/></td>
                        <td style="vertical-align: middle; text-align: center; max-width: 600px; width: 600px"><c:out value="${log.message}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
</div>
</body>
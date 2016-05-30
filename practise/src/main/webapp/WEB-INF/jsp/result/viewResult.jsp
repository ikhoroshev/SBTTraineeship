<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Result TestRun</title>
    <jsp:include page="../header.jsp"/>
</head>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <table class="table table-stripped">
        <thead>
        <tr>User: ${user.lastName} ${user.middleName} ${user.firstName} </tr>
        </thead>
    </table>
    <hr/>
    <% int i=0; %>
    <table class="table table-stripped">
        <thead>
        <tr>
            <th>Question</th>
            <th>Answer</th>
            <sec:authorize access="hasAuthority('1')">
                <th>IsRight</th>
            </sec:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="result" items="${result}">
            <tr>
                <td><c:out value="${result.question.text}"/></td>
                <c:forEach var="resultquestion" items="${result.question.answers}">
                    <c:if test="${resultquestion.id==result.answer.id}">
                        <td><c:out value="${resultquestion.text}"/></td>
                    </c:if>
                </c:forEach>
                <c:forEach var="resultquestion" items="${result.question.answers}">
                    <c:if test="${resultquestion.id==result.answer.id}">
                        <c:choose>
                            <c:when test="${resultquestion.isRight}">
                                <sec:authorize access="hasAuthority('1')">
                                    <td>yes</td>
                                </sec:authorize>
                                <% i++; %>
                            </c:when>
                            <c:otherwise>
                                <sec:authorize access="hasAuthority('1')">
                                    <td>no</td>
                                </sec:authorize>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </c:forEach>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%= "Number of correct answers: " + i%>
</div>
</body>
</html>

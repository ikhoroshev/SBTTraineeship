<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Question list</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <form:form modelAttribute="question" action="${pageContext.request.contextPath}/questions/find2" method="POST" class="form-horizontal"
               id="search-question-form">
        <div class="form-group has-feedback">

            <div>
                <label for="text">Keywords </label>
                <form:input class="form-control" path="text" size="30" maxlength="80" id="text"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>

            <div>
                <label for="testChapter">Chapter </label>
                <form:select class="form-control" path="testChapter.title" id="testChapter">
                    <c:forEach var="chapter" items="${allTestChapter}">
                        <form:option value="${chapter.title}"/>
                    </c:forEach>
                    <c:forEach var="chapter" items="${curChapter}">
                        <form:option value="${chapter.title}"/>
                    </c:forEach>
                </form:select>
                <%--<script src="http://code.jquery.com/jquery-1.4.2.min.js">
                    $("testChapter").value("second");


                </script>--%>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>

            <div>
                <button class="btn btn-default" type="submit">View questions</button>
                <a class="btn btn-default" href='<spring:url value="/questions/add" htmlEscape="true"/>'>Add Question</a>
            </div>
        </div>

        <c:if test="${searchQuestion != null}">
            <table class="table table-stripped">
                <thead>
                <tr>
                    <th>Question</th>
                    <th>Answers</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="question" items="${searchQuestion}">
                    <tr>
                        <td><c:out value="${question.text}"/></td>
                        <td><c:forEach var="answers" items="${question.answers}">
                            <c:out value="${answers.text}"/>
                            <c:if test="${answers.isRight}">
                                &nbsp;( + )
                            </c:if>
                        </c:forEach>
                        </td>
                        <td>
                            <a class="btn bt btn-default" href='<spring:url value="/questions/delete/${question.id}"/>'>Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </form:form>
</div>
</body>
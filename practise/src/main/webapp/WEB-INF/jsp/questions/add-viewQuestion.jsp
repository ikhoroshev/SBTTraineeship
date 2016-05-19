<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Question list</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <form:form modelAttribute="question" action="./find2" method="POST" class="form-horizontal"
               id="search-question-form">
        <div class="form-group has-feedback">

            <div>
                <label for="text">Text </label>
                <form:input class="form-control" path="text" size="30" maxlength="80" id="text"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>

            <div>
                <label for="testChapter">Chapter </label>
                <form:input class="form-control" path="testChapter.title" size="30" maxlength="80" id="testChapter"/>
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
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </form:form>
</div>
</body>
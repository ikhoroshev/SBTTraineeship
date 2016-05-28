<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<title>Add question</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>

<div class="container xd-container">
    <spring:url value="/questions/add" var="addQuestion"/>
    <form:form modelAttribute="question" action="${addQuestion}" method="post" class="form-horizontal">
        <div class="form-group has-feedback">
            <div>
                <label for="text">Text </label>
                <form:textarea class="form-control textarea long-field" path="text" rows="5" id="text"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>
            <div>
                <table>
                    <tr>
                        <td>Answer Type :</td>
                        <td>
                            <form:radiobutton path="answerType" value="SINGLE" />SINGLE <form:radiobutton
                                path="answerType" value="MULTIPLE" />MULTIPLE
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <label for="testChapter">Chapter </label>

                            <form:select class="form-control" path="testChapter.title" id="testChapter">
                                <c:forEach var="chapter" items="${allTestChapter}">
                                    <form:option value="${chapter.title}"/>
                                </c:forEach>
                            </form:select>

                            <span class="help-inline"><form:errors path="*"/></span>
                        </td>
                    </tr>
                </table>

                <table class="table table-stripped">
                    <thead>
                        <tr>
                            <th>Answer</th>
                            <th>Correct?</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td>
                                <form:input class="form-control" path="answer[0].text" size="60" maxlength="100" />
                                <span class="help-inline"><form:errors path="*"/></span>
                            </td>
                            <td>
                                <form:checkbox path="answer[0].isRight"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:input class="form-control" path="answer[1].text" size="60" maxlength="100" />
                                <span class="help-inline"><form:errors path="*"/></span>
                            </td>
                            <td>
                                <form:checkbox path="answer[1].isRight"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:input class="form-control" path="answer[2].text" size="60" maxlength="100" />
                                <span class="help-inline"><form:errors path="*"/></span>
                            </td>
                            <td>
                                <form:checkbox path="answer[2].isRight"/>
                            </td>
                        </tr>
                    </tbody>
                </table>

            </div>
            <div>
                <button class="btn btn-default" type="submit">Add question</button>
                <a class="btn btn-default" href='<spring:url value="#" htmlEscape="true"/>'>Cancel</a>
            </div>
        </div>
    </form:form>
</div>
</body>

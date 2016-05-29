<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Add Question</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <form:form modelAttribute="question" action="${pageContext.request.contextPath}/questions/find" method="POST" class="form-horizontal" id="add-question-form">
        <div class="form-group has-feedback">
            <table class="table">
                <thead>
                    <tr>
                        <th style="text-align: center">Question</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <div style="text-align: center">
                                <%--скрытые поля для редактирования вопроса--%>
                                <form:input type="hidden" path="id" id="id"/>
                                <form:input type="hidden" path="type" id="type"/>

                                <form:textarea cssStyle="resize: none" path="text" cols="100" rows="6" id="text"/>
                                <c:if test="${questionError==null}">
                                    <br><br>
                                </c:if>
                                <c:if test="${questionError!=null}">
                                    <br>
                                    <b style="color: #843534">
                                        <c:out value="${questionError}"/>
                                    </b>
                                </c:if>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            <table class="table">
                <thead>
                    <tr>
                        <th>Chapter</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <div style="width: 700px">
                                <form:select class="form-control" path="testChapter.title" id="testChapter">
                                    <c:forEach var="chapter" items="${allTestChapter}">
                                        <form:option value="${chapter.title}"/>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </td>
                        <td style="vertical-align: middle; text-align: center">
                            <div>
                                <c:if test="${chapterError!=null}">
                                    <b style="color: #843534">
                                        <c:out value="${chapterError}"/>
                                    </b>
                                </c:if>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            <table class="table">
                <thead>
                <tr>
                    <th>Answer</th>
                    <th style="text-align: center">Correct?</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <form:input class="form-control" path="answers[0].text" maxlength="255" id="text"/>
                    </td>
                    <td style="text-align: center; vertical-align: middle">
                        <form:checkbox path="answers[0].isRight"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:input class="form-control" path="answers[1].text" maxlength="255" id="text"/>
                    </td>
                    <td style="text-align: center; vertical-align: middle">
                        <form:checkbox path="answers[1].isRight"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:input class="form-control" path="answers[2].text" maxlength="255" id="text"/>
                    </td>
                    <td style="text-align: center; vertical-align: middle">
                        <form:checkbox path="answers[2].isRight"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:input class="form-control" path="answers[3].text" maxlength="255" id="text"/>
                    </td>
                    <td style="text-align: center; vertical-align: middle">
                        <form:checkbox path="answers[3].isRight"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        <div>
                            <c:if test="${answerError!=null}">
                                <b style="color: #843534">
                                    <c:out value="${answerError}"/>
                                </b>
                            </c:if>
                            <c:if test="${rightError!=null}">
                                <b style="color: #843534">
                                    <c:out value="${rightError}"/>
                                </b>
                            </c:if>
                            <c:if test="${answerError==null&&rightError==null}">
                                <br>
                            </c:if>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>

            <div style="text-align: center">
                <button class="btn btn-default" type="submit">Add Question</button>
                <c:if test="${isEdit}">
                    <a class="btn bt btn-default" href='<spring:url value="/questions/find/"/>'>Delete Question</a>
                </c:if>
                <c:if test="${isEdit==false}">
                    <a class="btn bt btn-default" href='<spring:url value="/questions/find/"/>'>Cancel</a>
                </c:if>

            </div>
        </div>
    </form:form>
</div>
</body>
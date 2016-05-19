<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Add Question</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <form:form modelAttribute="question" action="./find" method="POST" class="form-horizontal" id="add-question-form">
        <div class="form-group has-feedback">
            <table class="table table-stripped">
                <thead>
                    <tr>
                        <th>Question</th>
                        <th>Type</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <div>
                                <form:textarea path="text" cols="100" rows="5" id="text"/>
                                <span class="help-inline"><form:errors path="*"/></span>
                            </div>
                        </td>
                        <td>
                            <div>
                                <form:radiobuttons path="type" id="type" items="${QuestionType}" delimiter="<br>" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label for="testChapter">Chapter </label>
                            <form:select class="form-control" path="testChapter.title" id="testChapter">
                                <c:forEach var="chapter" items="${allTestChapter}">
                                    <form:option value="${chapter.title}"/>
                                </c:forEach>
                            </form:select>
                            <span class="help-inline"><form:errors path="*"/></span>
                        </td>
                </tr>
                </tbody>
            </table>
            <table class="table table-stripped">
                <thead>
                <tr>
                    <th>Answer</th>
                    <th>Correct?</th>
                </tr>
                </thead>
                <tbody>



                </tbody>
            </table>
            <div>
                <button class="btn btn-default" type="submit">Add Question</button>
            </div>
        </div>
    </form:form>
</div>
</body>
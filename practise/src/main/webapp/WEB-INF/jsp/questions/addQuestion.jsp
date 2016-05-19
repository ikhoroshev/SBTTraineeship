<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Add Question</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <form:form modelAttribute="question" action="./find" method="POST" class="form-horizontal"
               id="search-question-form">
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
                    <form:textarea path="text" cols="70" rows="5" id="text"/>
                    <span class="help-inline"><form:errors path="*"/></span>
                </div>
                </td>
                <td>
                <div>
                    <%--<form:form modelAttribute="QuestionType"--%>
                    <form:radiobuttons path="type" id="type" items="${QuestionType}" delimiter="<br>" />
                </div>
                </td>
            </tr>
            </tbody>
        </table>


            <%--<div>
                <label for="testChapter">Chapter </label>
                <form:input class="form-control" path="testChapter.title" size="30" maxlength="80" id="testChapter"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>--%>
        <table class="table table-stripped">
            <thead>
            <tr>
                <th>Answer</th>
                <th>Correct?</th>
            </tr>
            </thead>
            <tbody >
            <tr>
                <td>

                    <form:form modelAttribute="answers" >
                    <form:input class="form-control" path="text" id="text" size="60" maxlength="200"/>
                    </form:form>
                </td>
                <%--<td>
                    <form:checkbox path="answers.isRight" id="answers" value="true"/>
                </td>--%>
            </tr>
            </tbody>
        </table>
                <div>
                    <button class="btn btn-default" type="submit">Add Question</button>
                </div>

        </div>
    </form:form>
</div>
</body>
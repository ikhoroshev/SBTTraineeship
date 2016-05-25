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
                                <form:textarea path="text" cols="100" rows="5" id="text" title="ffff"/>
                                <span class="help-inline"><form:errors path="*"/></span>
                            </div>
                        </td>
                        <td>
                            <div>
                                <form:radiobuttons path="type" id="type" items="${QuestionType}" delimiter="<br>" checked="checked" />
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
                            <%--<script>
                                document.getElementById('testChapter').options["%>"]
                            </script>--%>
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
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <form:input class="form-control" path="answers[0].text" size="60" maxlength="100" id="text"/>
                        <span class="help-inline"><form:errors path="*"/></span>
                    </td>
                    <td>
                        <%--<script>
                            var select=document.getElementById("type");
                            var index;
                            for(var i=0;i<select.length;i++)
                                if(select[i].checked)
                                        index=i;
                            if(index==2)--%>
                                    <form:checkbox path="answers[0].isRight"/>
                            <%--else <form:radiobutton path="answers[0].isRight"/>
                        </script>--%>

                    </td>
                </tr>
                <tr>
                    <td>
                        <form:input class="form-control" path="answers[1].text" size="60" maxlength="100" id="text"/>
                        <span class="help-inline"><form:errors path="*"/></span>
                    </td>
                    <td>
                        <form:checkbox path="answers[1].isRight"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="inputs">
                        <form:input class="form-control" path="answers[2].text" size="60" maxlength="100" id="text"/>
                        </div>
                        <span class="help-inline"><form:errors path="*"/></span>
                    </td>
                    <td>
                        <form:checkbox path="answers[2].isRight"/>
                    </td>
                    <td>
                        <%--<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
                        <script>
                            function add_input(){
                                //var len=2;
                                var inputs = $('.inputs input[type="text"]');
                                var new_id = inputs.length+1;
                                $('.inputs').append('<tr><td><input id="text" name="answers[3]" class="form-control" type="text" value="" size="60" maxlength="100" /></td>'+
                                        '<td><input id="answers3.isRight1" name="answers[3].isRight" type="checkbox" value="true"/><input type="hidden" name="_answers[3].isRight" value="on"/></td>'+
                                        '<td></td></tr>');
//                            <input id="text" name="answers[0].text" class="form-control" type="text" value="" size="60" maxlength="100"/>
                            }
                        </script>--%>
                        <input type="button" id="create-answer" name="create-answer" value="+" onclick="add_input()">
                    </td>
                </tr>
                </tbody>
            </table>
            <div>
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
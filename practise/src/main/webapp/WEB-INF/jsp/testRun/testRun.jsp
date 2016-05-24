<%@ page import="ru.sberbank.services.UserGroupServiceImpl" %>
<%@ page import="ru.sberbank.web.UserController" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<title>User list</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">

    <c:if test="${testRun!=null}">
        <c:if test="${testRun.testRunStatus == 'NEW'}">
            <c:set target="${testRun}" property="testRunStatus" value="RUNNING"/>

            <form:form modelAttribute="testRun"  method="post" class="form-horizontal">
                <div>
                    <div>

                    </div>
                    <div>
                        <button class="btn btn-default" type="submit">Start test</button>
                    </div>
                </div>
            </form:form>
        </c:if>
    </c:if>
    <c:if test="${question!=null}">
        <c:if test="${question.answerType=='SINGLE'}">
           <c:out value="SINGLE"/>
        </c:if>
        <c:if test="${question.answerType=='MULTIPLE'}">
            <c:forEach var="answerItem" items="${question.answer}">
                <form:form modelAttribute="answers"  method="post" class="form-horizontal">
                    <div>
                        <div>
                            <form:checkbox path="isRight" value="TRUE"/>
                            <c:out value="${answerItem.text}|${question.id}|"/>
                        </div>
                        <div>
                            <input name="question.id" id="question.id" value="${question.id}" hidden="true"  />
                        </div>
                       <div>
                           <button class="btn btn-default" type="submit">Next question</button>
                       </div>

                    </div>

                </form:form>
            </c:forEach>


        </c:if>
    </c:if>
</div>
</body>
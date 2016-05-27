<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User test</title>
    <jsp:include page="../header.jsp"/>
</head>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <c:if test="${type == 0}">
        <c:out value="${question.text}"/>
        <form:form modelAttribute="question" method="get">
            <div class="form-group has-feedback">
                <div>
                    <form:radiobuttons path="id" id="type" items="${answers}" itemLabel="text" itemValue="id" delimiter="<br>" checked="checked" />
                </div>
                <div>
                    <button class="btn btn-default" type="submit">Next</button>
                </div>
            </div>
        </form:form>
    </c:if>
    <c:if test="${type == 1}">
        <c:out value="${question.text}"/>
        <form:form modelAttribute="question" method="get">
            <div class="form-group has-feedback">
                <div>
                    <form:checkboxes path="id" id="" items="${answers}" itemLabel="text" itemValue="id" delimiter="<br>" checked="checked" />
                </div>
                <div>
                    <button class="btn btn-default" type="submit">Next</button>
                </div>
            </div>
        </form:form>
        <h1>MULTIPLE</h1>
    </c:if>
</div>
</body>
</html>
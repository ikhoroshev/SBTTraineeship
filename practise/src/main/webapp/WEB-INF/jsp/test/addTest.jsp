<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<title>Test List</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>

<div class="container xd-container">
    <form:form modelAttribute="test" action="${pageContext.request.contextPath}/test/addTest" method="post" class="form-horizontal" id="search-test-form">
        <div class="form-group has-feedback">
            <div>
                <label for="title">Title </label>
                <form:input class="form-control" path="title" size="30" maxlength="80" id="title"/>
            </div>
            <div>
                <label for="description">Description </label>
                <form:textarea class="form-control textarea long-field" path="description" rows="5" id="description"/>
            </div>
            <div>
                <button class="btn btn-default" type="submit">Add test</button>
                <a class="btn btn-default" href='<spring:url value="/tests/find" htmlEscape="true"/>'>View Tests</a>
            </div>
        </div>
    </form:form>
</div>
</body>

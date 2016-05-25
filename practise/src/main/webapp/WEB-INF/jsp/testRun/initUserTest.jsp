<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>User test</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
<form:form modelAttribute="testRun" action="/testapp/testRun/playUserTest" method="get" class="form-horizontal" id="search-userTest-form">
    <div class="form-group has-feedback">
        <div>
            <label for="user">User </label>
            <form:select class="form-control" path="${user.id}" name="userId" id="user">
                <form:options  items="${userList}" itemLabel="lastName" itemValue="id"/>
            </form:select>
            <span class="help-inline"><form:errors path="*"/></span>
        </div>
        <div>
            <label for="test">Test </label>
            <form:select class="form-control" path="${test.id}" name="testId" id="test">
                <form:options  items="${testList}" itemLabel="title" itemValue="id"/>
            </form:select>
            <span class="help-inline"><form:errors path="*"/></span>
        </div>
        <div>
            <button class="btn btn-default" type="submit">Play user test</button>
            <a class="btn btn-default" href='<spring:url value="/users/find" htmlEscape="true"/>'>Cancel</a>
        </div>
    </div>
</form:form>
</div>

</body>


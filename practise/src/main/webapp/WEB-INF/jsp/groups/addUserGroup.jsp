<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>User group list</title>
    <jsp:include page="../header.jsp"/>
</head>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <form:form modelAttribute="userGroup" action="/testapp/groups/add" method="GET" class="form-horizontal" id="search-userGroup-form">
        <div class="form-group has-feedback">
            <div>
                <label for="name">Name</label>
                <form:input class="form-control" path="name" size="30" maxlength="80" id="name"/>
                <span class="help-inline"><form:errors path="name"/></span>
            </div>
            <div>
                <label form="type">Type</label>
                <form:select class="form-control" path="type"  id="type">
                    <form:options  items="${userGroupType}"/>
                </form:select>
                <span class="help-inline"><form:errors path="type"/></span>
            </div>
            <div>
                <button class="btn btn-default" type="submit">Add user group</button>
                <a class="btn btn-default" href='<spring:url value="/" htmlEscape="true"/>'>Cancel</a>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>

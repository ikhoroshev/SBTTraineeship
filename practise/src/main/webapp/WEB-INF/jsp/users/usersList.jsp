<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
</head>

<body>
<spring:url value="/users/find" var="findUsersForm"/>
<nav class="navbar navbar-default" role="navigation">
<a href="${findUsersForm}">Find users</a></nav>
</nav>
<div class="container xd-container">
    Hello world!
    <spring:url value="/users" var="findUsers"/>
    <form:form modelAttribute="user" action="${findUsers}" method="get" class="form-horizontal"
                       id="search-user-form">
        <div>
            <div>
                <label for="userName">Last name </label>
                <form:input class="form-control" path="name" size="30" maxlength="80" id="userName"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>
            <div>
            <label for="userGroup">Group name </label>
                <form:input class="form-control" path="group.name" size="30" maxlength="80" id = "userGroup"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>
        </div>
        <div>
            <div>
                <button class="btn btn-default" type="submit">Find users</button>
            </div>
        </div>

    <div class="form-group">
        <a class="btn btn-default" href='<spring:url value="/users/add" htmlEscape="true"/>'>Add User</a>
        <a class="btn btn-default" href='<spring:url value="/users/delete" htmlEscape="true"/>'>Delete User</a>
    </div>
    <c:if test="${searchResult != null}">
        <table class="table table-stripped" style="width:600px;">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Group name</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${searchResult}">
                <tr>
                    <td><c:out value="${user.name}"/></td>
                    <td>
                        <c:out value="${user.group.name}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    </form:form>
    </div>
</body>
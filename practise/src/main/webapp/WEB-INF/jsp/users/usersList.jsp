<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Добавление пользователя</title>
<jsp:include page="../header.jsp"/>

<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    Hello world!
    <spring:url value="/users" var="findUsers"/>
    <form:form modelAttribute="user" action="${findUsers}" method="get" class="form-horizontal"
                       id="search-user-form">
        <div>
            <div>
                <label for="userName">Last name </label>
                <form:input class="form-control" path="lastName" size="30" maxlength="80" id="userName"/>
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
                <a class="btn btn-default" href='<spring:url value="/users/add" htmlEscape="true"/>'>Add User</a>
            </div>
        </div>

    <c:if test="${searchResult != null}">
        <table class="table table-stripped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Group name</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${searchResult}">
                <tr>
                    <td><c:out value="${user.lastName} ${user.middleName} ${user.firstName}"/></td>
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
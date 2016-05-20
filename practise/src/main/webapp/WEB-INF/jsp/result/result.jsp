<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<title>User list</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <spring:url value="/result" var="result"/>
    <form:form modelAttribute="userGroup" action="${result}" method="post" class="form-horizontal">
        <div class="form-group has-feedback">

            <div>
                <label for="id">Group</label>
                <form:select path="id" cssClass="form-control">
                    <c:if test="${listUserGroup != null}">
                        <c:forEach var="userGroup" items="${listUserGroup}">
                            <form:option value="${userGroup.id}">${userGroup.name}</form:option>
                        </c:forEach>
                    </c:if>
                </form:select>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>
            <div>
                <br>
                <button class="btn btn-default" type="submit">Add user</button>

            </div>
        </div>
    </form:form>
</div>
</body>
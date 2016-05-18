<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 17.05.2016
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<title>Search Test</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <form:form modelAttribute="user" action="${findUsers}" method="post" class="form-horizontal"
    id="search-test-form">
        <button class="btn btn-default" type="submit">Search test </button>
        <a class="btn btn-default" href='<spring:url value="/users/add" htmlEscape="true"/>'>Add Test</a>
    </form:form>

</div>
</body>
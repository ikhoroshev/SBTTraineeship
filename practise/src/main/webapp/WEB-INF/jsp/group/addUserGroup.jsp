<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<title>Group add</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <form:form modelAttribute="userGroup" method="post" class="form-horizontal"
               id="search-userGroup-form">
        <div class="form-group has-feedback">
            <div>
                <label for="name">Group name</label>
                <form:input class="form-control" path="name" size="30" maxlength="80" id="name"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>
            <div>
                <button class="btn btn-default" type="submit">Add group</button>
                <a class="btn btn-default" href='<spring:url value="/group/add" htmlEscape="true"/>'>Cancel</a>
            </div>
        </div>
    </form:form>
</div>
</body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Tests</title>
<jsp:include page="../header.jsp"/>
<body>
  <jsp:include page="../navigation.jsp"/>
  
  <div class="container xd-container">
    <form:form modelAttribute="test" method="post" class="form-horizontal" id="search-test-form">
      <div class="form-group has-feedback">
        <div>
          <label for="title">Title </label>
          <form:input class="form-control" path="title" size="30" maxlength="80" id="title"/>
          <span class="help-inline"><form:errors path="*"/></span>
        </div>
        <div>
          <label for="description">Description </label>
          <form:input class="form-control" path="description" size="100" maxlength="80" id="description"/>
          <span class="help-inline"><form:errors path="*"/></span>
        </div>
        <div>
          <button class="btn btn-default" type="submit">Add test</button>
          <a class="btn btn-default" href='<spring:url value="#" htmlEscape="true"/>'>Cancel</a>
        </div>
      </div>
    </form:form>
  </div>
</body>
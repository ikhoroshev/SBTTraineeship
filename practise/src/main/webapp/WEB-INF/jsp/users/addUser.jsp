<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<title>User list</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
 <form:form modelAttribute="user" method="post" class="form-horizontal"
                       id="search-user-form">
                       <div class="form-group has-feedback">
                                   <div>
                                       <label for="lastName">Last name </label>
                                       <form:input class="form-control" path="lastName" size="30" maxlength="80" id="lastName"/>
                                       <span class="help-inline"><form:errors path="*"/></span>
                                   </div>
                                   <div>
                                        <label for="middleName">Middle name </label>
                                        <form:input class="form-control" path="middleName" size="30" maxlength="80" id="middleName"/>
                                        <span class="help-inline"><form:errors path="*"/></span>
                                   </div>
                                   <div>
                                     <label for="firstName">First name </label>
                                     <form:input class="form-control" path="firstName" size="30" maxlength="80" id="firstName"/>
                                     <span class="help-inline"><form:errors path="*"/></span>
                                   </div>
                                   <div>
                                       <button class="btn btn-default" type="submit">Add user</button>
                                       <a class="btn btn-default" href='<spring:url value="/users/find" htmlEscape="true"/>'>Cancel</a>
                                   </div>
                       </div>
 </form:form>
 </div>
</body>
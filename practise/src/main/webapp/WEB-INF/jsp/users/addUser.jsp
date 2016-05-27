<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>User list</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
 <form:form modelAttribute="user" action="/testapp/users/add" method="POST" class="form-horizontal"
                       id="search-user-form">
                       <div class="form-group has-feedback">
                           <div style="width: 600px">
                               <label for="firstName">First name </label>
                               <form:input class="form-control" path="firstName" size="30" maxlength="80" id="firstName"/>
                               <span class="help-inline"><form:errors path="*"/></span>
                           </div>
                           <div style="width: 600px">
                               <label for="lastName">Last name </label>
                               <form:input class="form-control" path="lastName" size="30" maxlength="80" id="lastName"/>
                               <span class="help-inline"><form:errors path="*"/></span>
                           </div>
                           <div style="width: 600px">
                               <label for="middleName">Middle name </label>
                               <form:input class="form-control" path="middleName" size="30" maxlength="80" id="middleName"/>
                               <span class="help-inline"><form:errors path="*"/></span>
                           </div>

                           <br>

                           <div style="width: 500px">
                               <label for="username">Username </label>
                               <form:input class="form-control" path="username" size="30" maxlength="80" id="username"/>
                               <span class="help-inline"><form:errors path="*"/></span>
                           </div>
                           <div style="width: 500px">
                               <label for="password">Password </label>
                               <form:password class="form-control" path="password" size="30" maxlength="80" id="password"/>
                               <span class="help-inline"><form:errors path="*"/></span>
                           </div>

                           <br>

                           <div style="width: 400px">
                               <label for="group">Group </label>
                               <form:select class="form-control" path="group.id" id="group">
                                   <form:options  items="${userGroups}" itemLabel="name" itemValue="id"/>
                               </form:select>
                               <span class="help-inline"><form:errors path="*"/></span>
                           </div>

                           <br>

                           <div>
                               <button class="btn btn-default" type="submit">Add user</button>
                               <a class="btn btn-default" href='<spring:url value="/users/find" htmlEscape="true"/>'>Cancel</a>
                           </div>
                       </div>
 </form:form>
 </div>
</body>
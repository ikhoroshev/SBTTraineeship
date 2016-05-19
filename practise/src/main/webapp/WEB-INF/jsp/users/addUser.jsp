<%@ page import="ru.sberbank.services.UserGroupServiceImpl" %>
<%@ page import="ru.sberbank.web.UserController" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>User list</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
 <form:form modelAttribute="user" method="post" class="form-horizontal">
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
                               <label for="group.id">Group</label>
                               <form:select path="group.id" cssClass="form-control">
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
                               <a class="btn btn-default" href='<spring:url value="/users/find" htmlEscape="true"/>'>Cancel</a>
                           </div>





                       </div>
 </form:form>


 </div>
</body>
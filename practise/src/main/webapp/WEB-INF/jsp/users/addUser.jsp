<%@ page import="ru.sberbank.services.UserGroupServiceImpl" %>
<%@ page import="ru.sberbank.web.UserController" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<title>User list</title>
<jsp:include page="../header.jsp"/>
<body>
    <jsp:include page="../navigation.jsp"/>
    
    <div class="container">
        <div class="row">
            <div class="signup-form col-sm-4 col-sm-offset-4">

                <form:form modelAttribute="user" method="post" class="form-horizontal">

                    <div class="form-group has-feedback">
                        <form:input class="form-control" path="login" size="30" placeholder="username" maxlength="80" id="username"/>
                        <span class="help-inline"><form:errors path="*"/></span>
                    </div>
                    <div class="form-group has-feedback">
                        <form:password class="form-control" path="password" size="30" placeholder="password" maxlength="80" id="password"/>
                        <span class="help-inline"><form:errors path="*"/></span>
                    </div>
                    <div class="form-group has-feedback">
                        <form:password class="form-control" path="confirmPassword" size="30" placeholder="Confirm password" maxlength="80" id="password-confirmation"/>
                        <span class="help-inline"><form:errors path="*"/></span>
                    </div>
                    <div class="form-group has-feedback">
                        <form:input class="form-control" path="lastName" size="30" placeholder="lastname" maxlength="80" id="lastName"/>
                        <span class="help-inline"><form:errors path="*"/></span>
                    </div>
                    <div class="form-group has-feedback">
                        <form:input class="form-control" path="middleName" size="30" placeholder="middlename" maxlength="80" id="middleName"/>
                        <span class="help-inline"><form:errors path="*"/></span>
                    </div> 
                    <div class="form-group has-feedback">
                        <form:input class="form-control" path="firstName" size="30" placeholder="firstname" maxlength="80" id="firstName"/>
                        <span class="help-inline"><form:errors path="*"/></span>
                    </div> 
                    <div class="form-group has-feedback">
                        <form:select path="group.id" cssClass="form-control">
                            <c:if test="${listUserGroup != null}">
                              <c:forEach var="userGroup" items="${listUserGroup}">
                                  <form:option value="${userGroup.id}">${userGroup.name}</form:option>
                              </c:forEach>
                            </c:if>
                        </form:select>
                        <span class="help-inline"><form:errors path="*"/></span>
                    </div>
                    <div class="form-group has-feedback">
                        <button class="btn btn-default" type="submit">Зарегистрироваться</button>
                        <a class="btn btn-default" href='<spring:url value="/users/find" htmlEscape="true"/>'>Отмена</a>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    
</body>
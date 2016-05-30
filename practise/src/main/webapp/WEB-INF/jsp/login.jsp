<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<title>Авторизация</title>
<jsp:include page="header.jsp"/>

<body>
    <jsp:include page="navigation.jsp"/>
    <spring:url value="/login" var="loginUrl"/>
    
    <div class="container">
        <div class="row">
            <div class="signup-form col-sm-4 col-sm-offset-4">

                <form action="${loginUrl}" method="POST">
                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            Неверное имя пользователя и/или пароль
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div class="alert alert-warning">
                            You have been logged out.
                        </div>
                    </c:if>
                        
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" size="30" placeholder="username" name="username" maxlength="80" id="username"/>
                        <span class="help-inline"><form:errors path="*"/></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" size="30" placeholder="password" name="password" maxlength="80" id="password"/>
                        <span class="help-inline"><form:errors path="*"/></span>
                    </div>

                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                    
                    <div class="form-group has-feedback">                        
                        <button class="btn btn-default" type="submit">Войти</button>
                        <a class="btn btn-default" href='<spring:url value="/" htmlEscape="true"/>'>Отмена</a>
                    </div>
                </form>
                    
            </div>
        </div>
    </div>
</body>
</html>

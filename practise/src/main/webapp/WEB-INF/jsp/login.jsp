<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="header.jsp"/>
<body>
<%--<jsp:include page="navigation.jsp"/>--%>
<spring:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post">
    <table style="text-align: center; vertical-align: middle; margin: auto; margin-top: 60px">
        <tr>
            <td>
                <p>
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username"/>
                </p>
            </td>
        </tr>
        <tr>
            <td>
                <p>
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password"/>
                </p>
            </td>
        </tr>
        <tr>
            <td>
                <input type="checkbox" id="remember_me" name="_spring_security_remember_me">
                <label for="remember_me" class="checkbox-inline">Remember me</label>
            </td>
        </tr>
        <tr>
            <td>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <button type="submit" class="btn">Log in</button>
            </td>
        </tr>
        <tr>
            <td>
                <c:if test="${param.error != null}">
                    <p>
                        Invalid username or password.
                    </p>
                </c:if>
                <c:if test="${param.logout != null}">
                    <p>
                        You have been logged out.
                    </p>
                </c:if>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

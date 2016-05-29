<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/testapp/resources/css/main.css" type="text/css"/>



<html>
<title>Welcome</title>
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="navigation.jsp"/>


<div class="buttonInCentr">
    <button type="button" class="btn btn-primary marginTop btn-lg " style="width:100%"
            onClick='location.href="/testapp/login"'> Войти
    </button> <br><br>
    <button type="button" class="btn btn-warning btn-lg "
            onClick='location.href="/testapp/testrun"'> Зарегистрироваться
    </button>
</div>

</body>

</html>
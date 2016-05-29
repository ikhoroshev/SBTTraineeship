<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<head>
    <meta charset="utf-8">
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrap"/>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapTheme"/>
    <script src="/testapp/resources/js/jquery-1.12.4.min.js"></script>
    <script src="/testapp/resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/testapp/resources/css/footer.css" type="text/css"/>
    <link rel="stylesheet" href="${bootstrap}" />
    <link rel="stylesheet" href="${bootstrapTheme}" />
    <link rel="shortcut icon" href="/testapp/resources/image/MiniLogo.png" type="image/png">
</head>
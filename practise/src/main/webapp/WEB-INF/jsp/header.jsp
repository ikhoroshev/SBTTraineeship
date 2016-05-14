<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrap"/>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapTheme"/>
    <link rel="stylesheet" href="${bootstrap}" />
    <link rel="stylesheet" href="${bootstrapTheme}" />
</head>
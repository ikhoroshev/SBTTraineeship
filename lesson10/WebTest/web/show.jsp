<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP</title>
</head>
<body>

<%= request.getParameter("parameter")%><br>

<%= session.getAttribute("session_parameter")%><br>

</body>
</html>

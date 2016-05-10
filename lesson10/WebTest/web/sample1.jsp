<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%= new java.util.Date()%><br>

    <%! private int i = 100;%>

    <%
      out.println("Text " + i);
    %><br>
</body>
</html>

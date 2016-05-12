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

    <form method="GET" action="/">
        <input type="text" name="param" value="">
        <input type="submit" value="Get">
    </form>
    <br>
    <form method="POST" action="/">
        <input type="text" name="param" value="">
        <input type="submit" value="Post">
    </form>

</body>
</html>

<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="navigation.jsp"/>

<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
        Dropdown
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li>
        <li role="separator" class="divider"></li>
        <li><a href="#">Separated link</a></li>
    </ul>
</div>
<% Authentication auth = SecurityContextHolder.getContext().getAuthentication();%>
<sec:authorize access="hasRole('TEACHER')">

    This content will only be visible to users who have
    the "supervisor" authority in their list of <tt>GrantedAuthority</tt>s.

</sec:authorize>


</body>
</html>
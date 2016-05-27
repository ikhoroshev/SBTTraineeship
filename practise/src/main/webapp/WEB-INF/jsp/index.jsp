<html>
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="navigation.jsp"/>
<title> Wellcome </title>
<div class="dropdown">
    <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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


<sec:authorize access="hasRole('111')">

    This content will only be visible to users who have
    the "supervisor" authority in their list of <tt>GrantedAuthority</tt>s.

</sec:authorize>

</body>
</html>
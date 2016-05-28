<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<html>
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="navigation.jsp"/>

<sec:authorize access="hasAuthority('PUPIL')">
12232
</sec:authorize>

<sec:authorize access="hasAuthority('TEACHER')">
    <div class="dropdown marginTop">
        <button class="btn btn-success dropdown-toggle btn-lg" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            Tests
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="/testapp/tests/search">Search tests</a></li>
            <li><a href="/testapp/tests/add">Add tests</a></li>
            <li><a href="/testapp/tests/search/dellete">Remove tests</a></li>
                <%--<li role="separator" class="divider"></li>--%>
                <%--<li><a href="#">Separated link</a></li>--%>
        </ul>

    </div>
</sec:authorize>





</body>

</html>
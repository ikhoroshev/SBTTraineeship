<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<spring:url value="/users/find" var="findUsersForm"/>
<link rel="stylesheet" href="/testapp/resources/css/navigation.css" type="text/css"/>
<nav class="navbar navbar-default" role="navigation">
    <div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-left">
                <a href="/testapp">
                    <div class="marginRightLogo">
                        <img src="/testapp/resources/image/SBTLogoFinal.png" alt="SberT">
                    </div>
                </a>
            </ul>

            <sec:authentication var="principal" property="principal"/>

            <ul class="nav navbar-nav navbar-right removeMarginRight">
                <div class="marginTop">
                    <strong> ${principal} </strong>
                </div>
            </ul>
            <sec:authorize access="hasAuthority('PUPIL')">


                <ul class="nav navbar-nav navbar-right removeMarginRight">
                    <li>
                        <button type="button" class="btn btn-danger marginTop btn-lg "
                                onClick='location.href="/testapp/testrun"'> TAKE THE TEST
                        </button>
                    </li>
                </ul>
            </sec:authorize>

            <sec:authorize access="hasAuthority('TEACHER')">

                <ul class="nav navbar-nav navbar-right marginRight">
                    <div class="dropdown marginTop">
                        <button class="btn btn-success dropdown-toggle btn-lg" type="button" id="dropdownMenu1"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
                </ul>

                <ul class="nav navbar-nav navbar-right marginRight">
                    <div class="dropdown marginTop">
                        <button class="btn btn-info dropdown-toggle btn-lg" type="button" id="dropdownMenu2"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            Users
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                            <li><a href="/testapp/users/find">Search users</a></li>
                            <li><a href="/testapp/users/add">Add users</a></li>
                            <li><a href="/testapp/users/search/dellete">Remove tests</a></li>
                        </ul>
                    </div>

                </ul>
            </sec:authorize>
        </div>
    </div>


    <footer class="footer">
        <br>
        <p>THIS IS FOOTER</p>
    </footer>
</nav>
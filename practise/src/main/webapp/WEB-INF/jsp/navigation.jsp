
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
            <ul class="nav navbar-nav navbar-right removeMarginRight">
                <li>
                    <button type="button" class="btn btn-primary marginTop btn-lg " onClick='location.href="/testapp/login"'> Sign IN</button>
                </li>
             </ul>
            <ul class="nav navbar-nav navbar-right marginRight">

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
            </ul>
        </div>
    </div>
</nav>
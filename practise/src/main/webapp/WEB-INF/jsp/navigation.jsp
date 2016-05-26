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
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<spring:url value="/users/find" />"><span></span><span> <div class="menuItem">Find users </div></span></a></li>
             </ul>
            <ul class="nav navbar-nav navbar-right">
                <div class="dropdown">
                    <button class="btn btn-default dropdown-toggle btn-lg" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
            </ul>
        </div>
    </div>
</nav>
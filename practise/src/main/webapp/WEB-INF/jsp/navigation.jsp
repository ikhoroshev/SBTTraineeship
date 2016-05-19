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
        </div>
    </div>
</nav>
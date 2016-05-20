<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/users/find" var="findUsersForm"/>
<nav class="navbar navbar-default" role="navigation">
<div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<spring:url value="/questions/find" />"><span> Find questions</span></a>
                </li>
                <li>
                    <a href="<spring:url value="/users/find" />"><span> Find users</span></a>
                </li>
                <li>
                    <a href="<spring:url value="/groups/find" />"><span> Find group</span></a>
                </li>
                <li>
                    <a href="<spring:url value="/test/addTest" />"><span> Find test</span></a>
                </li>>
             </ul>
        </div>
    </div>
</nav>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/users/find" var="findUsersForm"/>
<nav class="navbar navbar-default" role="navigation">
<div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<spring:url value="/log/find" />"><span> Log</span></a>
                </li>
                <li>
                    <a href="<spring:url value="/questions/find" />"><span> Find questions</span></a>
                </li>
                <li>
                    <a href="<spring:url value="/users/find" />"><span> Users</span></a>
                </li>
                <li>
                    <a href="<spring:url value="/groups/find" />"><span> Group</span></a>
                </li>
                <li>
                    <a href="<spring:url value="/chapters/find" />"><span> Find chapters</span></a>
                </li>
                <li>
                    <a href="<spring:url value="/test/find" />"><span> Test </span></a>
                </li>
                <li>
                    <a href="<spring:url value="/testRun/initUserTest" />"><span> Test user</span></a>
                </li>
             </ul>
        </div>
    </div>
</nav>
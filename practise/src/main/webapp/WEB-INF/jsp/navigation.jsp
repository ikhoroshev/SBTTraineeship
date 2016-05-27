<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--<spring:url value="/users/find" var="findUsersForm"/>--%>
<nav class="navbar navbar-default" role="navigation">
<div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="hasAuthority('1')">
                    <li>
                        <a href="<spring:url value="/log/find" />"><span> Log</span></a>
                    </li>
                    <li>
                        <a href="<spring:url value="/questions/find" />"><span> Questions</span></a>
                    </li>
                    <li>
                        <a href="<spring:url value="/users/find" />"><span> Users</span></a>
                    </li>
                    <li>
                        <a href="<spring:url value="/groups/find" />"><span> Groups</span></a>
                    </li>
                    <li>
                        <a href="<spring:url value="/chapters/find" />"><span> Chapters</span></a>
                    </li>
                </sec:authorize>

                    <li>
                        <a href="<spring:url value="/test/find" />"><span> Test</span></a>
                    </li>
                    <li>
                        <a href="<spring:url value="/testRun/initUserTest" />"><span> Test user</span></a>
                    </li>

                    <li>
                        <a href="<c:url value="/logout"/>"><span><b> Logout <sec:authentication property='principal.username'/></b></span></a>
                    </li>
             </ul>
        </div>
    </div>
</nav>
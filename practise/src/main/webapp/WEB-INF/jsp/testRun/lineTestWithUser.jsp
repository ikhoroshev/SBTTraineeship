<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Link test questions</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<c:set var="s" value="-1"/>
<div class="container xd-container">

    <select id="slc" multiple='multiple' size="10" class="selection-handle">

        <c:if test="${users!=null}">
            <c:forEach items="${users}" var="user">
                <c:if test="${s!=user.group.id}">
                    <c:set var="s" value="${user.group.id}"/>
                    <optgroup label="${user.group.name}">
                </c:if>
                <div>
                    <option id="u${user.id}" value="${user.group.name}">${user.lastName} </option>
                </div>
                <c:if test="${s!=user.group.id}">
                    </optgroup>
                    <c:set var="s" value="${user.group.id}"/>
                </c:if>
            </c:forEach>
        </c:if>
    </select>

    <button id="add" onclick="swap('slc','slc2')">&Gt;</button>
    <button id="delete" onclick="swap('slc2','slc')">&Lt;</button>

    <c:set var="s" value="-1"/>

    <select id="slc2" multiple="true"  size="10">
        <c:if test="${usersTest!=null}">
            <c:forEach items="${usersTest}" var="user">
                <c:if test="${s!=user.group.id}">
                    <c:set var="s" value="${user.group.id}"/>
                    <optgroup label="${user.group.name}">
                </c:if>
                <div>
                    <option id="u${user.id}" value="${user.group.name}">${user.lastName} </option>
                </div>
                <c:if test="${s!=user.group.id}">
                    </optgroup>
                    <c:set var="s" value="${user.group.id}"/>
                </c:if>
            </c:forEach>
        </c:if>
    </select>
</div>

<form:form modelAttribute="test" method="post" id="testForm">
    <form:select path="id" onchange="submit('testForm')" id="testId">
        <c:forEach items="${tests}" var="test">
            <form:option value="${test.id}">${test.title}</form:option>
        </c:forEach>
    </form:select>
</form:form>

<br><br><br><br><br><br><br><br>
<button class="btn btn-default" onclick="createFormQuestions('slc2','testId','massID')" >Send id test</button>




<form:form modelAttribute="collectionFromForm" method="post" id="massID">

</form:form>
<script src="<c:url value="/resources/js/tests/add.js"/>"></script>


</body>
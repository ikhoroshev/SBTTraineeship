<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Link test questions</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<link rel="stylesheet" href="/testapp/resources/css/tests/testLinkQuestions.css" type="text/css"/>

<c:set var="s" value="-1"/>
<div class="container xd-container">

    <div class="questions">
        <select id="slc" multiple='multiple' size="10" class="selection form-control">

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
        <div class="controlDiv">
            <div>
        <button id="add" onclick="swap('slc','slc2')"  class="control btn btn-default">&#8659;</button>
        </div>
        <div>
            <form:form modelAttribute="test" method="post" id="testForm" cssClass="controlForm">
                <form:select path="id" onchange="submit('testForm')" id="testId" cssClass="controlSelect form-control">
                    <c:forEach items="${tests}" var="test">
                        <form:option value="${test.id}">${test.title}</form:option>
                    </c:forEach>
                </form:select>
            </form:form>
        </div>
       <div>
           <button id="delete" onclick="swap('slc2','slc')"  class="control btn btn-default">&#8657;</button>
       </div>
</div>
        <c:set var="s" value="-1"/>

        <select id="slc2" multiple="true"  size="10" class="selection form-control">
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
        <div class="send">
    <button class="btn btn-default" onclick="createFormQuestions('slc2','testId','massID')" >Send id test</button>
    </div>
        <form:form modelAttribute="collectionFromForm" method="post" id="massID">
    </form:form>
</div>






<script src="<c:url value="/resources/js/tests/add.js"/>"></script>


</body>
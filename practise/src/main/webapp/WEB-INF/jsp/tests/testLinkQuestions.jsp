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

            <c:if test="${questions!=null}">
            <c:forEach items="${questions}" var="user" varStatus="stat">
                <c:if test="${s!=user.testChapter.position}">
                    <c:set var="s" value="${user.testChapter.position}"/>
                    <optgroup label="${user.testChapter.title}">
                </c:if>
                <div>
                    <option id="q${user.id}" value="${user.testChapter.title}">${user.text} </option>
                </div>
                    <c:if test="${s!=user.testChapter.position}">
                    </optgroup>
                        <c:set var="s" value="${user.testChapter.position}"/>
                    </c:if>
            </c:forEach>
            </c:if>
        </select>

        <button id="add" onclick="swap('slc','slc2')">&Gt;</button>
        <button id="delete" onclick="swap('slc2','slc')">&Lt;</button>

    <c:set var="s" value="-1"/>

        <select id="slc2" multiple="true"  size="10">
            <c:if test="${questionsInTest!=null}">
                <c:forEach items="${questionsInTest}" var="user" varStatus="stat">
                    <c:if test="${s!=user.testChapter.position}">
                        <c:set var="s" value="${user.testChapter.position}"/>
                        <optgroup label="${user.testChapter.title}">
                    </c:if>
                    <div>
                        <option id="q${user.id}" value="${user.testChapter.title}">${user.text} </option>
                    </div>
                    <c:if test="${s!=user.testChapter.position}">
                        </optgroup>
                        <c:set var="s" value="${user.testChapter.position}"/>
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
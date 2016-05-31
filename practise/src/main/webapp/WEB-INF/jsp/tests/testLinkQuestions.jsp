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
        <select id="slc" multiple='multiple' size="10" class="selection form-control" >

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

    <div class="controlDiv">
        <div>
            <button id="add" onclick="swap('slc','slc2')" class="control btn btn-default" >	&#8659;</button>
        </div>

<div>
    <form:form modelAttribute="test" method="post" id="testForm" cssClass="controlForm" >
        <form:select path="id" onchange="submit('testForm')" id="testId" cssClass="form-control controlSelect">
            <c:forEach items="${tests}" var="test">
                <form:option value="${test.id}">${test.title}</form:option>
            </c:forEach>
        </form:select>
    </form:form>
</div>
        <div>
            <button id="delete" onclick="swap('slc2','slc')" class="control btn btn-default">&#8657;</button>
        </div>



    </div>


        <c:set var="s" value="-1"/>

        <select id="slc2" multiple="true"  size="10" class="selection form-control">
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
    <div class="send">
        <button class="btn btn-default" onclick="createFormQuestions('slc2','testId','massID')">
            Save in the test questions</button>
    </div>


    <form:form modelAttribute="collectionFromForm" method="post" id="massID">

    </form:form>
</div>





<script src="<c:url value="/resources/js/tests/add.js"/>"></script>


</body>
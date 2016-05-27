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
            <c:forEach items="${questions}" var="question" varStatus="stat">
                <c:if test="${s!=question.testChapter.position}">
                    <optgroup label="${question.testChapter.title}">
                </c:if>
                <div>
                    <option id="q${question.id}" value="${question.testChapter.title}">${question.text} </option>
                </div>
                    <c:if test="${s!=question.testChapter.position}">
                    </optgroup>
                        <c:set var="s" value="${question.testChapter.position}"/>
                    </c:if>
            </c:forEach>
            </c:if>
        </select>
        <button id="add" onclick="swap('slc','slc2')">&Gt;</button>
        <button id="delete" onclick="swap('slc2','slc')">&Lt;</button>
        <select id="slc2" multiple="true"  size="10">
            <c:if test="${questionsInTest!=null}">
                <c:forEach items="${questionsInTest}" var="question" varStatus="stat">
                    <c:if test="${s!=question.testChapter.position}">
                        <optgroup label="${question.testChapter.title}">
                    </c:if>
                    <div>
                        <option id="q${question.id}" value="${question.testChapter.title}">${question.text} </option>
                    </div>
                    <c:if test="${s!=question.testChapter.position}">
                        </optgroup>
                        <c:set var="s" value="${question.testChapter.position}"/>
                    </c:if>
                </c:forEach>
            </c:if>
        </select>
</div>


    <button class="btn btn-default" onclick="createFormQuestions('slc2')" >Send id test</button>

<script src="<c:url value="/resources/js/tests/add.js"/>"></script>


</body>
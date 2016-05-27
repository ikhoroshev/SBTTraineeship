<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Link test questions</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<c:set var="s"/>
<div class="container xd-container">
    <c:if test="${questions!=null}">
        <select id="slc" multiple='multiple' size="10" class="selection-handle">
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

        </select>
        <button id="add" onclick="swap('slc','slc2')">&Gt;</button>
        <button id="delete" onclick="swap('slc2','slc')">&Lt;</button>
        <select id="slc2" multiple="true"  size="10">

        </select>
    </c:if>
</div>
<script src="<c:url value="/resources/js/tests/add.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-1.12.4.min.js"/>"></script>

</body>
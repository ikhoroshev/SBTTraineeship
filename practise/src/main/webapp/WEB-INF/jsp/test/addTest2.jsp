<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Add Questions To Test</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>
<div class="container xd-container">
    <form:form modelAttribute="test" action="${pageContext.request.contextPath}/test/addTest2" method="POST" class="form-horizontal" id="add-question2test-form">
        <div class="form-group has-feedback">
            <form:input path="title" type="hidden" id="title"/>
            <form:input path="description" type="hidden" id="description"/>

            <form:select path="questions" multiple="true" size="10" id="selq" name="selq">
                <form:options items="${questionList}"/>
            </form:select>



            <div style="text-align: center">
                <button class="btn btn-default" type="submit">Add Test</button>

                <a class="btn bt btn-default" href='<spring:url value="/test/find/"/>'>Cancel</a>


            </div>
        </div>
    </form:form>
</div>
</body>
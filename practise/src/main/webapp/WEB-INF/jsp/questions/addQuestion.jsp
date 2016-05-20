<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<title>Add question</title>
<jsp:include page="../header.jsp"/>
<body>
<jsp:include page="../navigation.jsp"/>

<div class="container xd-container">
    <form:form modelAttribute="question" method="post" class="form-horizontal" id="search-test-form">
        <div class="form-group has-feedback">
            <div>
                <label for="text">Text </label>
                <form:textarea class="form-control textarea long-field" path="text" rows="5" id="text"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>
            <div>
                <table>
                    <tr>
                        <td>Answer Type :</td>
                        <td>

                            <form:radiobutton path="answerType" value="SINGLE" />SINGLE <form:radiobutton
                                path="answerType" value="MULTIPLE" />MULTIPLE
                        </td>
                    </tr>

                </table>
            </div>
            <div>
                <button class="btn btn-default" type="submit">Add question</button>
                <a class="btn btn-default" href='<spring:url value="#" htmlEscape="true"/>'>Cancel</a>
            </div>
        </div>
    </form:form>
</div>
</body>

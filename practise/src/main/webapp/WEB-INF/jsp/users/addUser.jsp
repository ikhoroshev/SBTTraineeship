<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<title></title>
<body>
<div class="container xd-container">
 <form:form modelAttribute="user" action="${findUsers}" method="post" class="form-horizontal"
                       id="search-user-form">
                       <div class="form-group has-feedback">
                                   <div>
                                       <label for="lastName">Last name </label>
                                       <form:input class="form-control" path="lastName" size="30" maxlength="80" id="lastName"/>
                                       <span class="help-inline"><form:errors path="*"/></span>
                                   </div>
                                   <div>
                                        <label for="middleName">Middle name </label>
                                        <form:input class="form-control" path="middleName" size="30" maxlength="80" id="middleName"/>
                                        <span class="help-inline"><form:errors path="*"/></span>
                                   </div>
                                   <div>
                                     <label for="firstName">First name </label>
                                     <form:input class="form-control" path="firstName" size="30" maxlength="80" id="firstName"/>
                                     <span class="help-inline"><form:errors path="*"/></span>
                                   </div>
                       <div>
                                   <div>
                                       <button class="btn btn-default" type="submit">Add user</button>
                                   </div>
                               </div>
 </form:form>
 </div>
</body>
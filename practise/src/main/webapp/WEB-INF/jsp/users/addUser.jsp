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
                                       <label for="userName">Last name </label>
                                       <form:input path="name" size="30" maxlength="80" id="userName"/>
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<spring:url value="/users/find" var="findUsersForm"/>
<link rel="stylesheet" href="/testapp/resources/css/navigation.css" type="text/css"/>
<nav class="navbar navbar-default" role="navigation">
    <div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-left">
                <a href="/testapp">
                    <div class="marginRightLogo" style="margin-top: 1%;">
                        <img src="/testapp/resources/image/SBTLogoFinal.png" alt="SberT">
                    </div>
                </a>
            </ul>
            <sec:authorize access="hasAnyAuthority('PUPIL', 'TEACHER')">
                <sec:authentication var="principal" property="principal"/>

                <ul class="nav navbar-nav navbar-right removeMarginRight">
                    <div class="marginTop">
                        <address>
                            <strong>Логин: </strong> ${principal} <br>
                            <c:url var="logoutUrl" value="/logout"/>
                            <form action="/testapp/logout" method="post" style="overflow: hidden; float: left">
                                <input type="submit" class=" btn-warning btn-sm btn" value="Выйти"/>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </address>


                    </div>
                </ul>
            </sec:authorize>
            <sec:authorize access="hasAuthority('PUPIL')">
                <div class="marginTop">

                    <ul class="nav navbar-nav navbar-right marginRight">
                        <li>
                            <button type="button" class="btn btn-danger marginTop btn-lg "
                                    onClick='location.href="/testapp/testRun/listTests"'> Пройти тест
                            </button>
                        </li>
                    </ul>
                </div>
            </sec:authorize>

            <sec:authorize access="hasAuthority('TEACHER')">
                <div class="marginTop">
                    <ul class="nav navbar-nav navbar-right marginRight">
                        <div class="dropdown ">
                            <button class="btn btn-success dropdown-toggle btn-lg  " type="button" id="dropdownMenu1"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                Тесты
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li><a href="/testapp/tests/search">Найти тест</a></li>
                                <li><a href="/testapp/tests/add">Добавить тест</a></li>
                                <li><a href="/testapp/tests/search/dellete">Удалить тест</a></li>
                                <li><a href="/testapp/result">Результаты</a></li>
                                    <%--<li role="separator" class="divider"></li>--%>
                                    <%--<li><a href="#">Separated link</a></li>--%>
                            </ul>
                        </div>
                    </ul>


                    <ul class="nav navbar-nav navbar-right marginRight">
                        <div class="dropdown ">
                            <button class="btn btn-default dropdown-toggle btn-lg " type="button" id="dropdownMenu3"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                Группы
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li><a href="/testapp/group/add">Добавить группу</a></li>
                            </ul>
                        </div>
                    </ul>


                    <ul class="nav navbar-nav navbar-right marginRight">
                        <div class="dropdown ">
                            <button class="btn btn-info dropdown-toggle btn-lg " type="button" id="dropdownMenu2"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                Пользователи
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li><a href="/testapp/users/find">Найти пользователя</a></li>
                                <li><a href="/testapp/registration">Добавить пользователя</a></li>
                                <li><a href="/testapp/users/find">Удалить пользователя</a></li>
                            </ul>
                        </div>
                    </ul>


                </div>

            </sec:authorize>
        </div>
    </div>


    <footer class="footer" style="overflow: hidden">
        <img src="/testapp/resources/image/sberTech.png" class="imgLeftMargin" alt="SberT">
        <div class="footer_textRight">
            <address style="display: inline">
                <small>
                    <strong>Контакты: </strong><br>
                    <strong>Наталья Беломестных<br></strong>
                    <a href="nebelomestnyh.sbt@sberbank.ru">nebelomestnyh.sbt@sberbank.ru</a><br>
                    <strong><abbr title="Phone"></abbr> +7 (913) 158-68-57 </strong>
                </small>
            </address>
        </div>
    </footer>
</nav>
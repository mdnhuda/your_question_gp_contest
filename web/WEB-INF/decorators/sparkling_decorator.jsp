<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>

<%@ taglib uri="/c.tld" prefix="c" %>
<%@ taglib prefix="spring" uri="/spring.tld" %>
<%@ taglib uri="sitemesh-decorator" prefix="decorator" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title><decorator:title default="Charity template"/></title>
    <link href='<c:url value="/res/sparkling_style.css"/>' rel="stylesheet" type="text/css">
    <decorator:head/>
</head>

<body>
<div id="wrapper">
    <div id="header-wrapper">
        <div id="header">
            <div id="logo">
                <h1>
                    <a href="#">
                    <span><spring:message code="app.name.first"/>
                    </span><spring:message code="app.name.second"/>
                    </a>
                </h1>
                <p> <spring:message code="created.by"/> <a href="#"> Naimul Huda </a></p>

            </div>

            <div id="user-info">
                <span><c:out value="${loggedUser.name}"/></span>
                <span>
                    <a href="<c:url value='/app/editProfile/${loggedUser.id}'/>">
                                <spring:message code="profile.my.label"/>
                            </a>
                </span>
                <span>
                    <c:choose>
                        <c:when test="${empty loggedUser}">
                            <a href="<c:url value='/app/login'/>"><spring:message code="login.label"/></a>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value='/app/logout'/>"><spring:message code="logout.label"/></a>
                        </c:otherwise>
                    </c:choose>
                </span>

                <span>&nbsp;&nbsp;</span>
                <span>
                    <a href="<c:url value='/app/changeLanguage?lang=bn'/>"><spring:message code="language.bangla"/></a>
                    |<a href="<c:url value='/app/changeLanguage?lang=en'/>"><spring:message code="language.english"/></a>
                </span>
            </div>

            <div id="menu">
                <%--<span><a href="<c:url value='/app/home'/>"><spring:message code="home.title"/></a></span>--%>
                <%--<span><a href="<c:url value='/app/questions/add'/>"><spring:message code="question.create"/></a></span>--%>
                <%--<span><a href="<c:url value='/res/static/our_work.jsp'/>"><spring:message code="our.work"/></a></span>--%>
                <%--<span><a href="<c:url value='/res/static/about_us.jsp'/>"><spring:message code="about.us"/></a></span>--%>
                <ul>
                    <li><a href="<c:url value='/app/home'/>"><spring:message code="home.title"/></a></li>
                    <li><a href="<c:url value='/app/questions/add'/>"><spring:message code="question.create"/></a></li>
                    <li><a href="<c:url value='/res/static/our_work.jsp'/>"><spring:message code="our.work"/></a></li>
                    <li><a href="<c:url value='/res/static/about_us.jsp'/>"><spring:message code="about.us"/></a></li>
                </ul>
            </div>
        </div>
    </div>
    <!-- end #header -->
    <div id="page">
        <c:if test="${not empty commonMsg}">
            <div id="commonMsg">
                <spring:message code="${commonMsg}" text="${commonMsg}"/>
            </div>
        </c:if>

        <!------------ body starts -------->
        <decorator:body/>
        <!------------ body ends -------->
        <div style="clear: both;">&nbsp;</div>
    </div>
    <!-- end #page -->
</div>

<div id="footer">
    <p><spring:message code="footer.text"/></p>
</div>
<!-- end #footer -->
</body>
</html>

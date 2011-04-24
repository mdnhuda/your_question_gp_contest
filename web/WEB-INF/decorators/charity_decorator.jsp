<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>

<%@ taglib uri="/c.tld"		prefix="c" %>
<%@ taglib prefix="spring" uri="/spring.tld"%>
<%@ taglib uri="sitemesh-decorator" prefix="decorator" %>

<html>
<head>
    <title><decorator:title default="Charity template"/></title>
    <link href='<c:url value="/res/charity_style.css"/>' rel="stylesheet" type="text/css">
    <decorator:head/>
</head>

<body>
<div id="container">
	<div id="header">
		<div id="logo_w1">Charitable</div>
		<div id="logo_w2">Organization</div>

		<div id="header_text">
			<p><spring:message code="header.text"/></p>
		</div>
		<ul>
			<li><a href="<c:url value='/'/>">Home</a></li>
			<li><a href="<c:url value='/res/static/about_us.jsp'/>">About Us</a></li>
			<li><a href="<c:url value='/res/static/our_work.jsp'/>">Our Work</a></li>
			<li><a href="<c:url value='/res/static/contact_us.jsp'/>">Contact us</a></li>
            <li>
                <c:if test="${empty loggedUser}">
                  <a href="<c:url value='/app/login'/>"><spring:message code="login.label"/></a>
                </c:if>
                <c:if test="${!empty loggedUser}">
                  <a href="<c:url value='/app/editProfile?id=${loggedUser.id}'/>">
                      <spring:message code="profile.my.label"/>
                  </a>
                  <a href="<c:url value='/app/logout'/>"><spring:message code="logout.label"/></a>
                </c:if>
            </li>
		</ul>


	</div>

	<div id="content">
        <div>
            <!------------ body starts -------->
            <decorator:body/>
            <!------------ body ends -------->
        </div>
        <div id="footerline"></div>
    </div>
	<div id="footer"><spring:message code="footer.text"/></div>
</div>

</body>
</html>

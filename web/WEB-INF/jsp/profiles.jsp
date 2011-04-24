<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="/c.tld" %>
<%@ taglib prefix="spring" uri="/spring.tld" %>

<html>
<head><title><spring:message code="profile.all.title"/></title></head>
<body>


<div id="page-bgtop">
    <div id="page-bgbtm">
        <div id="content">
            <table class="list">
                <thead>
                <tr>
                    <th><spring:message code="profile.name"/></th>
                    <th><spring:message code="profile.specialization"/></th>
                    <th><spring:message code="profile.note"/></th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${users}" var="u">
                    <tr>
                        <td><c:out value="${u.name}"/></td>
                        <td><c:out value="${u.specialization}"/></td>
                        <td><c:out value="${u.note}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
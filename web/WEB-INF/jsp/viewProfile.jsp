<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="/c.tld" %>
<%@ taglib prefix="spring" uri="/spring.tld" %>

<html>
<head><title><spring:message code="profile.title"/></title></head>
<body>

<div id="page-bgtop">
    <div id="page-bgbtm">
        <div id="content">
            <table>
                <tr>
                    <td><spring:message code="profile.name"/></td>
                    <td><c:out value="${cmd.name}"/></td>
                </tr>
                <%--<tr>--%>
                <%--<td><spring:message code="profile.email"/></td>--%>
                <%--<td><c:out value="${cmd.email}"/></td>--%>
                <%--</tr>--%>
                <tr>
                    <td><spring:message code="profile.address"/></td>
                    <td><c:out value="${cmd.email}"/></td>
                </tr>
                <%--<tr>--%>
                <%--<td><spring:message code="profile.phone.number"/></td>--%>
                <%--<td><c:out value="${cmd.phoneNumber}"/></td>--%>
                <%--</tr>--%>
                <tr>
                    <td><spring:message code="profile.specialization"/></td>
                    <td><c:out value="${cmd.specialization}"/></td>
                </tr>
                <tr>
                    <td><spring:message code="profile.note"/></td>
                    <td><c:out value="${cmd.note}"/></td>
                </tr>
            </table>
        </div>
    </div>
</div>


</body>
</html>
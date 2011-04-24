<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="/c.tld" %>
<%@ taglib prefix="spring" uri="/spring.tld" %>
<%@ taglib prefix="form" uri="/spring-form.tld" %>

<html>
<head><title><spring:message code="login.label"/></title></head>
<body>

<div id="page-bgtop">
    <div id="page-bgbtm">
        <div id="content">
            <form:form method="post" commandName="cmd">
                <form:errors path="*" cssClass="errorBox"/>

                <table>
                    <tr>
                        <td><spring:message code="profile.userId"/></td>
                        <td><form:input path="email"/></td>
                    </tr>
                    <tr>
                        <td><spring:message code="profile.password"/></td>
                        <td><form:password path="password"/></td>
                    </tr>
                </table>

                <div id="buttons">
                    <input type="submit" name="submitButton" value="Submit">
                </div>

            </form:form>

            <br/>
            <spring:message code="register.text"/>
            <a href="<c:url value='/app/createProfile'/>"><spring:message code="register.label"/></a>

        </div>
    </div>
</div>


</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="/c.tld" %>
<%@ taglib prefix="spring" uri="/spring.tld" %>
<%@ taglib prefix="form" uri="/spring-form.tld" %>

<html>
<head><title><spring:message code="profile.title"/></title></head>
<body>

<div id="page-bgtop">
    <div id="page-bgbtm">
        <div id="content">

            <form:form method="post" commandName="cmd">
                <form:errors path="*" cssClass="errorBox"/>

                <table>
                    <tr>
                        <td>
                            <spring:message code="profile.userId"/>
                        </td>
                        <td>
                            <form:hidden path="id"/>
                            <form:input path="userId"/>
                        </td>
                    </tr>
                    <tr>
                        <td><spring:message code="profile.password"/></td>
                        <td><form:password path="password"/></td>
                    </tr>
                    <tr>
                        <td><spring:message code="profile.password2"/></td>
                        <td><form:password path="password2"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                    <tr>
                        <td><spring:message code="profile.name"/></td>
                        <td><form:input path="name"/></td>
                    </tr>
                    <tr>
                        <td><spring:message code="profile.email"/></td>
                        <td><form:input path="email"/></td>
                    </tr>
                    <tr>
                        <td><spring:message code="profile.address"/></td>
                        <td><form:input path="address"/></td>
                    </tr>
                    <tr>
                        <td><spring:message code="profile.phone.number"/></td>
                        <td><form:input path="phoneNumber"/></td>
                    </tr>
                    <tr>
                        <td><spring:message code="profile.dob"/></td>
                        <td><form:input path="dob"/></td>
                    </tr>
                    <tr>
                        <td><spring:message code="profile.specialization"/></td>
                        <td><form:input path="specialization"/></td>
                    </tr>
                    <tr>
                        <td><spring:message code="profile.note"/></td>
                        <td><form:textarea path="note"/></td>
                    </tr>
                </table>

                <div id="buttons">
                    <input type="submit" name="submitButton" value="Submit">
                </div>

            </form:form>

        </div>
    </div>
</div>


</body>
</html>
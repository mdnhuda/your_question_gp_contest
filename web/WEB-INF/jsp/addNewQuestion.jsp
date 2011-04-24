<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="/c.tld" %>
<%@ taglib prefix="spring" uri="/spring.tld" %>
<%@ taglib prefix="form" uri="/spring-form.tld" %>

<html>
<head><title><spring:message code="question.create"/></title></head>
<body>

<div id="page-bgtop">
    <div id="page-bgbtm">
        <div id="content">
            <form:form method="post" commandName="cmd">
                <form:errors path="*" cssClass="errorBox"/>

                <table>
                    <tr>
                        <td><spring:message code="question.catagory"/></td>
                        <td><form:select path="category" items="${categoryList}"/></td>
                    </tr>
                    <tr>
                        <td><spring:message code="question.label"/></td>
                        <td><form:textarea path="text" rows="5" cols="50"/></td>
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
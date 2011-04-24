<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="/c.tld" %>
<%@ taglib prefix="spring" uri="/spring.tld" %>
<%@ taglib prefix="form" uri="/spring-form.tld" %>

<html>
<head>
    <title><spring:message code="question.label"/></title>
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
        google.load("search", "1");
        function initialize() {
            var searchControl = new google.search.SearchControl();
            searchControl.addSearcher(new google.search.WebSearch());
            searchControl.addSearcher(new google.search.NewsSearch());
            searchControl.addSearcher(new google.search.BlogSearch());
            searchControl.draw(document.getElementById("searchcontrol"));
        }
        google.setOnLoadCallback(initialize);
    </script>
</head>
<body>

<div id="page-bgtop">
    <div id="page-bgbtm">
        <div id="content">
            <div class="question">
                <div class="text">
                    <p><c:out value="${question.text}"/></p>
                </div>
                <p class="meta">
                      <span class="posted"><spring:message code="questioned.by"/>
                          <a href="<c:url value='/app/viewProfile/${question.createdBy.id}'/>">
                              <c:out value="${question.createdBy.name}"/> on <c:out value="${question.dateCreated}"/>
                          </a>
                      </span>
                </p>

                <div style="clear: both;">&nbsp;</div>
            </div>

            <c:forEach items="${question.answers}" var="ans">
                <div class="answer">
                    <div class="text"><c:out value="${ans.text}"/></div>
                    <p class="meta">
                        <span class="posted"><spring:message code="answered.by"/>
                            <a href="<c:url value='/app/viewProfile/${ans.createdBy.id}'/>">
                                <c:out value="${ans.createdBy.name}"/> on <c:out value="${ans.dateCreated}"/>
                            </a>
                        </span>
                    </p>
                    <div style="clear: both;">&nbsp;</div>
                </div>
            </c:forEach>


            <c:choose>
                <c:when test="${empty loggedUser}">
                    <c:set var="loginUrl">
                        <c:url value="/app/login">
                            <c:param name="redirectTo" value="/app/questions/${question.id}"/>
                        </c:url>
                    </c:set>
                    <p class="meta">
                        <a href="${loginUrl}">
                            <spring:message code="login.to.answer"/>
                        </a>
                    </p>
                </c:when>
                <c:otherwise>
                    <c:set var="submitUrl">
                        <c:url value="/app/questions/${question.id}/answer"/>
                    </c:set>
                    <form:form method="post" commandName="cmd" action="${submitUrl}">
                        <form:errors path="*" cssClass="errorBox"/>

                        <div>
                            <h3><spring:message code="answer.label"/></h3>

                            <div style="float:left">
                                <form:textarea path="text" rows="5" cols="50"/>
                                <input type="submit" name="submitButton" value="Submit">
                            </div>
                        </div>
                    </form:form>
                </c:otherwise>
            </c:choose>
        </div>

        <div id="sidebar">
            <h3>Search in Web</h3>
            <div id="searchcontrol"></div>
        </div>
        <div style="clear: both;">&nbsp;</div>
    </div>
</div>


</body>
</html>

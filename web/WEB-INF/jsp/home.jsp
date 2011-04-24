<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="/c.tld" %>
<%@ taglib prefix="spring" uri="/spring.tld" %>
<%@ taglib prefix="form" uri="/spring-form.tld" %>


<html>
<head><title><spring:message code="home.title"/></title></head>
<body>
<div id="page-bgtop">
    <div id="page-bgbtm">
        <div id="content">
            <div>
                <c:if test="${showPreviousLink}">
                  <span style="float:left">
                      <a href="<c:url value='/app/prev'/>"><spring:message code="common.label.prev"/></a>
                  </span>
                </c:if>
                <c:if test="${showNextLink}">
                  <span style="float:right">
                      <a href="<c:url value='/app/next'/>"><spring:message code="common.label.next"/></a>
                  </span>
                </c:if>

                <div style="clear: both;">&nbsp;</div>
            </div>

            <c:forEach items="${questions}" var="q">
                <div class="question">
                    <div class="text">
                        <p><c:out value="${q.text}"/></p>
                    </div>
                    <p class="meta">
                          <span class="posted"><spring:message code="questioned.by"/>
                              <a href="<c:url value='/app/viewProfile/${q.createdBy.id}'/>">
                                  <c:out value="${q.createdBy.name}"/> on <c:out value="${q.dateCreated}"/>
                              </a>
                          </span>
                    </p>
                        <%--<div style="clear: both;">&nbsp;</div>--%>
                    <div class="text">
                        <p class="links"><a href="<c:url value='/app/questions/${q.id}'/>"><spring:message
                                code="common.label.detail"/></a></p>
                    </div>
                </div>
            </c:forEach>
            <div style="clear: both;">&nbsp;</div>
        </div>
        <!-- end #content -->


        <div id="sidebar">
            <ul>
                <li>
                    <div id="search">
                        <form:form method="get" action="<c:url value='/app/search'/>">
                            <input type="text" name="queryStr" value="<c:if test='${not empty searchCmd}'><c:out value='${searchCmd.queryStr}'/></c:if>"/>
                            <input type="image" src="<c:url value='/res/images/search.gif'/>" alt="Search" />
                        </form:form>
                    </div>
                    <div style="clear:both;">&nbsp;</div>
                </li>

                <li>
                    <h3><spring:message code="common.label.search.by.categories"/></h3>
                    <div>
                        <p>
                            <c:forEach items="${categories}" var="cat">
                            <span style="float:right;padding:5px">
                                <a href="<c:url value='/app/search?queryStr=${cat}'/>">
                                    <c:out value="${cat}"/>
                                </a>
                            </span>
                            </c:forEach>
                        </p>
                    </div>
                    <div style="clear: both;">&nbsp;</div>

                    <ul>
                        <li><a href="<c:url value='/app/myQuestions'/>"><spring:message code="my.questions.label"/></a>
                        </li>
                        <li><a href="<c:url value='/app/unanswered'/>"><spring:message
                                code="unanswered.questions.label"/></a></li>
                        <li><a href="<c:url value='/app/answered'/>"><spring:message code="review.answers.label"/></a>
                        </li>
                    </ul>
                </li>

                <li>
                    <h2><spring:message code="common.label.user.ranking"/></h2>
                    <ul>
                        <c:forEach items="${topUsers}" var="user">
                            <li>
                                <a href="<c:url value='/app/viewProfile/${user.id}'/>">
                                    <c:out value="${user.name}"/> - <c:out value="${user.numberOfQuestionAnswered}"/>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- end #sidebar -->
        <div style="clear: both;">&nbsp;</div>
    </div>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="/c.tld"%>

<html>
  <head><title>Test App</title></head>
  <body>
    ${greetings}
  <br/>
    
  <a href="<c:url value='/app/showLocation?msisdn=8801717807270'/>">Click to get Location</a>
  </body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="/c.tld"%>

<html>
  <head><title>Show Location</title></head>
  <body>
    ${location}
  <br/>
  <br/>
  <br/>

  <form action="<c:url value='/location/show'/>">
      MSISDN: <input type="text" name="msisdn" maxlength="13">
      <input type="submit" name="submitButton" value="Get Location">
  </form>
  </body>

</html>
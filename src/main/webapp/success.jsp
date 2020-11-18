<%--
  Created by IntelliJ IDEA.
  User: Райымбек
  Date: 15.11.2020
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css">

</head>
<body>
<h1><% String emai = (String) session.getAttribute("email");  %> <%=emai%> successfully logged in!</h1>

<input type="button" onclick="window.location.href='Students.jsp'" value="List of Students"/>

<input type="button" onclick="window.location.href='Clubs.jsp'" value="List of Clubs"/>

<input type="button" onclick="window.location.href='Events.jsp'" value="List of Events"/>

<input type="button" onclick="window.location.href='News.jsp'" value="List of News"/>




<form class="form" action="<%= request.getContextPath() %>/LogoutServlet">

    <p><input type="submit" name="submit"  class="button-submit" value="logout"></p>

</form>

</body>
</html>

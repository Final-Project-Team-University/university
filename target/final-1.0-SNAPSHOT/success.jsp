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
    <title>Title</title>
</head>
<body>
<h1><% String emai = (String) session.getAttribute("email");  %> <%=emai%> successfully logged in!</h1>

<input type="button" onclick="window.location.href='Students.jsp'" value="List of Students"/>


<form action="${pageContext.request.contextPath}/EventServlet" method="get">

    <td><input type="submit" name="submit" value="List of Events"></td>

</form>
<form action="${pageContext.request.contextPath}/NewsServlet" method="get">

    <td><input type="submit" name="submit" value="List of News"></td>

</form>
<form action="${pageContext.request.contextPath}/ClubServlet" method="get">

    <td><input type="submit" name="submit" value="List of Clubs"></td>

</form>

<input type="button" onclick="window.location.href='http://localhost:8080/final_war_exploded/list'" value="List of Clubs"/>
<form class="form" action="<%= request.getContextPath() %>/LogoutServlet">

    <p><input type="submit" name="submit"  class="button-submit" value="logout"></p>

</form>

</body>
</html>

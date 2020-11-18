<%@ page import="Repo.IStudentRepo" %>
<%@ page import="Repo.StudentRepo" %>
<%@ page import="domain.Student" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Райымбек
  Date: 15.11.2020
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/table.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
</head>
<body>
<%
    IStudentRepo studentRepo = new StudentRepo();
    ArrayList<Student> students = studentRepo.query();
    Collections.sort(students);
%>


<div id="app" class="container">
    <div class="container">
        <h2>List of Students</h2>
        <ul class="responsive-table">
            <li class="table-header">
                <div class="col col-6">Student Name</div>
                <div class="col col-6">Student Major</div>
                <div class="col col-6">Student Group</div>
                <div class="col col-6">Student Year</div>
            </li>


            <% for(Student student : students){%>
            <li class="table-row">
                <div class="col col-6" data-label=""><%= student.getFirstname() + " " + student.getLastname()%></div>
                <div class="col col-6" data-label=""><%= student.getMajor() %></div>
                <div class="col col-6" data-label=""><%= student.getGroup() %></div>
                <div class="col col-6" data-label=""><%= student.getYear() %></div>

                <% } %>
            </li>
        </ul>
    </div>
</div>


</body>
</html>

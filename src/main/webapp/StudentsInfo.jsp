<%@ page import="Repo.IStudentRepo" %>
<%@ page import="domain.Student" %>
<%@ page import="Repo.StudentRepo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %><%--
  Created by IntelliJ IDEA.
  User: Райымбек
  Date: 15.11.2020
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/table.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<%

    Student student = (Student) request.getAttribute("student");


%>

<div id="app" class="container">
    <div class="container">
        <h2>Student Info</h2>
        <ul class="responsive-table">
            <li class="table-header">
                <div class="col col-10">Student Photo</div>
                <div class="col col-10">Student Name</div>
                <div class="col col-10">Student Surname</div>
                <div class="col col-10">Student Email</div>
                <div class="col col-10">Student Password</div>
                <div class="col col-10">Student Phone Number</div>
                <div class="col col-10">Student Academic Major</div>
                <div class="col col-10">Student Group</div>
                <div class="col col-10">Student Year</div>
            </li>



            <li class="table-row">
                <div class="col col-10" data-label=""><img src="<%= student.getUrl() %>" style="height: 50px; width: 50px;"/></div>
                <div class="col col-10" data-label=""><%= student.getFirstname() %></div>
                <div class="col col-10" data-label=""><%= student.getLastname() %></div>
                <div class="col col-10" data-label=""><%= student.getEmail() %></div>
                <div class="col col-10" data-label=""><%= student.getPassword() %></div>
                <div class="col col-10" data-label=""><%= student.getNumber() %></div>
                <div class="col col-10" data-label=""><%= student.getMajor() %></div>
                <div class="col col-10" data-label=""><%= student.getGroup() %></div>
                <div class="col col-10" data-label=""><%= student.getYear() %></div>

            </li>
        </ul>
    </div>


    <h3 class="mt-3">Student profile details</h3>
    <hr>
    <div class="row">
        <div class="col">
            <label class="start">Student Firstname</label>
            <input type="text" class="form-control" name="firstname" id="firstname" value="<%= student.getFirstname() %>">
            <h6 style="color: red" id="regisErr2"></h6>
        </div>
        <div class="col">
            <label class="start">Student Lastname</label>
            <input type="text" class="form-control" name="lastname" id="lastname" value="<%= student.getLastname() %>">
            <h6 style="color: red" id="regisErr3"></h6>
        </div>
        <div class="col">
            <label class="start">Student Email</label>
            <input type="text" class="form-control" name="email" id="email" value="<%= student.getEmail() %>">
            <input style="display: none;" id="student_id" value="<%=student.getId()%>">
            <h6 style="color: red" id="regisErr1"></h6>
        </div>
        <div class="col">
            <label class="start">Student Password</label>
            <input type="text" class="form-control" name="password" id="password" value="<%= student.getPassword() %>">
            <h6 style="color: red" id="regisErr4"></h6>
        </div>
        <div class="col">
            <label class="start">Student Photo</label>
            <input type="text" class="form-control" name="url" id="url" value="<%= student.getUrl() %>">
            <h6 style="color: red" id="regisErr5"></h6>
        </div>
        <div class="col">
            <label class="start">Student Number</label>
            <input type="text" class="form-control" name="number" id="number" value="<%= student.getNumber() %>">
            <h6 style="color: red" id="regisErr6"></h6>
        </div>
        <div class="col">
            <label class="start">Student Major</label>
            <input type="text" class="form-control" name="major" id="major" value="<%= student.getMajor() %>">
            <h6 style="color: red" id="regisErr7"></h6>
        </div>
        <div class="col">
            <label class="start">Student Group</label>
            <input type="text" class="form-control" name="group" id="group" value="<%= student.getGroup() %>">
            <h6 style="color: red" id="regisErr8"></h6>
        </div>
        <div class="col">
            <label class="start">Student Year</label>
            <input type="text" class="form-control" name="year" id="year" value="<%= student.getYear() %>">
            <h6 style="color: red" id="regisErr9"></h6>
        </div>
    </div>
    <br>
    <button style="background-color: #95A5A6; border:#95A5A6;" class="btn btn-info mt-0" id="btnRedact">Edit</button>
    <button style="" class="btn btn-danger" id="delete">Delete</button>

</div>


<script src="${pageContext.request.contextPath}/js/studentpage.js"></script>
</body>
</html>

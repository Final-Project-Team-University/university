<%@ page import="domain.Student" %>
<%@ page import="Repo.IStudentRepo" %>
<%@ page import="Repo.StudentRepo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %><%--
  Created by IntelliJ IDEA.
  User: Райымбек
  Date: 15.11.2020
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/table.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

</head>
<body>

<%
    if(session.getAttribute("admin")==null) {
        response.sendRedirect("login.jsp");
    }
    IStudentRepo studentRepo = new StudentRepo();
    ArrayList<Student> students = studentRepo.query();
    ArrayList<Student> studentsSE = studentRepo.querySE();
    ArrayList<Student> studentsCS = studentRepo.queryCS();
    ArrayList<Student> studentsBD = studentRepo.queryBD();
    ArrayList<Student> studentsM = studentRepo.queryM();
    ArrayList<Student> studentsGroupF = studentRepo.queryGroupF();
    ArrayList<Student> studentsGroupS = studentRepo.queryGroupS();
    ArrayList<Student> studentsFirst = studentRepo.queryFirst();
    ArrayList<Student> studentsSecond = studentRepo.querySecond();
    Collections.sort(students);
%>






<div class="tags">
    <h2>Select Options</h2>
    <label>
        <input type="checkbox" rel="software" />
        Software Engineering
    </label>
    <label>
        <input type="checkbox" rel="cyber" />
        Cyber Security
    </label>
    <label>
        <input type="checkbox" rel="bigd" />
        Big Data
    </label>
    <label>
        <input type="checkbox" rel="media" />
        Media
    </label>
    <label>
        <input type="checkbox" rel="1904" />
        1904
    </label>
    <label>
        <input type="checkbox" rel="1905" />
        1905
    </label>
    <label>
        <input type="checkbox" rel="first" />
        First Year
    </label>
    <label>
        <input type="checkbox" rel="second" />
        Second Year
    </label>
    <label style="padding-left: 5%">
        <input type="checkbox" rel="all" />
        Show all
    </label>
</div>



<ul class="results">
    <li class="software" type="none">

        <div id="app1" class="container">
            <div class="container">
                <ul class="responsive-table">
                    <li class="table-header">
                        <div class="col col-1">Student Name</div>
                        <div class="col col-2">Student Major</div>
                        <div class="col col-3">Student Group</div>
                        <div class="col col-4">Student Year</div>
                        <div class="col col-5">Student Info</div>
                    </li>


                    <% for(Student student : studentsSE){%>
                    <li class="table-row">
                        <div class="col col-1" data-label=""><%= student.getFirstname() + " " + student.getLastname()%></div>
                        <div class="col col-2" data-label=""><%= student.getMajor() %></div>
                        <div class="col col-3" data-label=""><%= student.getGroup() %></div>
                        <div class="col col-4" data-label=""><%= student.getYear() %></div>
                        <div class="col col-5" data-label="">
                            <form method="post" action="<%=request.getContextPath()%>/StudentsServlet">
                                <th>
                                    <input style="display: none;" name="student_id" value="<%=student.getId()%>">
                                    <button style="width: 50% ;background-color: #95A5A6; border:#95A5A6;" class="btn btn-info mt-0" id="change1">Info</button>
                                </th>
                            </form>
                        </div>
                        <% } %>
                    </li>
                </ul>
            </div>
        </div>




    </li>
    <li class="cyber" type="none">

        <div id="app2" class="container">
            <div class="container">
                <ul class="responsive-table">
                    <li class="table-header">
                        <div class="col col-1">Student Name</div>
                        <div class="col col-2">Student Major</div>
                        <div class="col col-3">Student Group</div>
                        <div class="col col-4">Student Year</div>
                        <div class="col col-5">Student Info</div>
                    </li>


                    <% for(Student student : studentsCS){%>
                    <li class="table-row">
                        <div class="col col-1" data-label=""><%= student.getFirstname() + " " + student.getLastname()%></div>
                        <div class="col col-2" data-label=""><%= student.getMajor() %></div>
                        <div class="col col-3" data-label=""><%= student.getGroup() %></div>
                        <div class="col col-4" data-label=""><%= student.getYear() %></div>
                        <div class="col col-5" data-label="">
                            <form method="post" action="<%=request.getContextPath()%>/StudentsServlet">
                                <th>
                                    <input style="display: none;" name="student_id" value="<%=student.getId()%>">
                                    <button style="width: 50% ;background-color: #95A5A6; border:#95A5A6;" class="btn btn-info mt-0" id="change2">Info</button>
                                </th>
                            </form>
                        </div>
                        <% } %>
                    </li>
                </ul>
            </div>
        </div>


    </li>
    <li class="bigd" type="none">


        <div id="app3" class="container">
            <div class="container">
                <ul class="responsive-table">
                    <li class="table-header">
                        <div class="col col-1">Student Name</div>
                        <div class="col col-2">Student Major</div>
                        <div class="col col-3">Student Group</div>
                        <div class="col col-4">Student Year</div>
                        <div class="col col-5">Student Info</div>
                    </li>


                    <% for(Student student : studentsBD){%>
                    <li class="table-row">
                        <div class="col col-1" data-label=""><%= student.getFirstname() + " " + student.getLastname()%></div>
                        <div class="col col-2" data-label=""><%= student.getMajor() %></div>
                        <div class="col col-3" data-label=""><%= student.getGroup() %></div>
                        <div class="col col-4" data-label=""><%= student.getYear() %></div>
                        <div class="col col-5" data-label="">
                            <form method="post" action="<%=request.getContextPath()%>/StudentsServlet">
                                <th>
                                    <input style="display: none;" name="student_id" value="<%=student.getId()%>">
                                    <button style="width: 50% ;background-color: #95A5A6; border:#95A5A6;" class="btn btn-info mt-0" id="change3">Info</button>
                                </th>
                            </form>
                        </div>
                        <% } %>
                    </li>
                </ul>
            </div>
        </div>


    </li>
    <li class="media" type="none">


        <div id="app4" class="container">
            <div class="container">
                <ul class="responsive-table">
                    <li class="table-header">
                        <div class="col col-1">Student Name</div>
                        <div class="col col-2">Student Major</div>
                        <div class="col col-3">Student Group</div>
                        <div class="col col-4">Student Year</div>
                        <div class="col col-5">Student Info</div>
                    </li>


                    <% for(Student student : studentsM){%>
                    <li class="table-row">
                        <div class="col col-1" data-label=""><%= student.getFirstname() + " " + student.getLastname()%></div>
                        <div class="col col-2" data-label=""><%= student.getMajor() %></div>
                        <div class="col col-3" data-label=""><%= student.getGroup() %></div>
                        <div class="col col-4" data-label=""><%= student.getYear() %></div>
                        <div class="col col-5" data-label="">
                            <form method="post" action="<%=request.getContextPath()%>/StudentsServlet">
                                <th>
                                    <input style="display: none;" name="student_id" value="<%=student.getId()%>">
                                    <button style="width: 50% ;background-color: #95A5A6; border:#95A5A6;" class="btn btn-info mt-0" id="change4">Info</button>
                                </th>
                            </form>
                        </div>
                        <% } %>
                    </li>
                </ul>
            </div>
        </div>

    </li>
    <li class="all" type="none">

        <div id="app" class="container">
            <div class="container">
                <h2>List of Students</h2>
                <ul class="responsive-table">
                    <li class="table-header">
                        <div class="col col-1">Student Name</div>
                        <div class="col col-2">Student Major</div>
                        <div class="col col-3">Student Group</div>
                        <div class="col col-4">Student Year</div>
                        <div class="col col-5">Student Info</div>
                    </li>


                    <% for(Student student : students){%>
                    <li class="table-row">
                        <div class="col col-1" data-label=""><%= student.getFirstname() + " " + student.getLastname()%></div>
                        <div class="col col-2" data-label=""><%= student.getMajor() %></div>
                        <div class="col col-3" data-label=""><%= student.getGroup() %></div>
                        <div class="col col-4" data-label=""><%= student.getYear() %></div>
                        <div class="col col-5" data-label="">
                            <form method="post" action="<%=request.getContextPath()%>/StudentsServlet">
                                <th>
                                    <input style="display: none;" name="student_id" value="<%=student.getId()%>">
                                    <button style="width: 50% ;background-color: #95A5A6; border:#95A5A6;" class="btn btn-info mt-0" id="change">Info</button>
                                </th>
                            </form>
                        </div>
                        <% } %>
                    </li>
                </ul>
            </div>
        </div>
    </li>
    <li class="1904" type="none">

        <div id="app5" class="container">
            <div class="container">
                <ul class="responsive-table">
                    <li class="table-header">
                        <div class="col col-1">Student Name</div>
                        <div class="col col-2">Student Major</div>
                        <div class="col col-3">Student Group</div>
                        <div class="col col-4">Student Year</div>
                        <div class="col col-5">Student Info</div>
                    </li>


                    <% for(Student student : studentsGroupF){%>
                    <li class="table-row">
                        <div class="col col-1" data-label=""><%= student.getFirstname() + " " + student.getLastname()%></div>
                        <div class="col col-2" data-label=""><%= student.getMajor() %></div>
                        <div class="col col-3" data-label=""><%= student.getGroup() %></div>
                        <div class="col col-4" data-label=""><%= student.getYear() %></div>
                        <div class="col col-5" data-label="">
                            <form method="post" action="<%=request.getContextPath()%>/StudentsServlet">
                                <th>
                                    <input style="display: none;" name="student_id" value="<%=student.getId()%>">
                                    <button style="width: 50% ;background-color: #95A5A6; border:#95A5A6;" class="btn btn-info mt-0" id="change5">Info</button>
                                </th>
                            </form>
                        </div>
                        <% } %>
                    </li>
                </ul>
            </div>
        </div>
    </li>

    <li class="1905" type="none">

        <div id="app6" class="container">
            <div class="container">
                <ul class="responsive-table">
                    <li class="table-header">
                        <div class="col col-1">Student Name</div>
                        <div class="col col-2">Student Major</div>
                        <div class="col col-3">Student Group</div>
                        <div class="col col-4">Student Year</div>
                        <div class="col col-5">Student Info</div>
                    </li>


                    <% for(Student student : studentsGroupS){%>
                    <li class="table-row">
                        <div class="col col-1" data-label=""><%= student.getFirstname() + " " + student.getLastname()%></div>
                        <div class="col col-2" data-label=""><%= student.getMajor() %></div>
                        <div class="col col-3" data-label=""><%= student.getGroup() %></div>
                        <div class="col col-4" data-label=""><%= student.getYear() %></div>
                        <div class="col col-5" data-label="">
                            <form method="post" action="<%=request.getContextPath()%>/StudentsServlet">
                                <th>
                                    <input style="display: none;" name="student_id" value="<%=student.getId()%>">
                                    <button style="width: 50% ;background-color: #95A5A6; border:#95A5A6;" class="btn btn-info mt-0" id="change6">Info</button>
                                </th>
                            </form>
                        </div>
                        <% } %>
                    </li>
                </ul>
            </div>
        </div>
    </li>

    <li class="first" type="none">

        <div id="app7" class="container">
            <div class="container">
                <ul class="responsive-table">
                    <li class="table-header">
                        <div class="col col-1">Student Name</div>
                        <div class="col col-2">Student Major</div>
                        <div class="col col-3">Student Group</div>
                        <div class="col col-4">Student Year</div>
                        <div class="col col-5">Student Info</div>
                    </li>


                    <% for(Student student : studentsFirst){%>
                    <li class="table-row">
                        <div class="col col-1" data-label=""><%= student.getFirstname() + " " + student.getLastname()%></div>
                        <div class="col col-2" data-label=""><%= student.getMajor() %></div>
                        <div class="col col-3" data-label=""><%= student.getGroup() %></div>
                        <div class="col col-4" data-label=""><%= student.getYear() %></div>
                        <div class="col col-5" data-label="">
                            <form method="post" action="<%=request.getContextPath()%>/StudentsServlet">
                                <th>
                                    <input style="display: none;" name="student_id" value="<%=student.getId()%>">
                                    <button style="width: 50% ;background-color: #95A5A6; border:#95A5A6;" class="btn btn-info mt-0" id="change7">Info</button>
                                </th>
                            </form>
                        </div>
                        <% } %>
                    </li>
                </ul>
            </div>
        </div>
    </li>



    <li class="second" type="none">

        <div id="app8" class="container">
            <div class="container">
                <ul class="responsive-table">
                    <li class="table-header">
                        <div class="col col-1">Student Name</div>
                        <div class="col col-2">Student Major</div>
                        <div class="col col-3">Student Group</div>
                        <div class="col col-4">Student Year</div>
                        <div class="col col-5">Student Info</div>
                    </li>


                    <% for(Student student : studentsSecond){%>
                    <li class="table-row">
                        <div class="col col-1" data-label=""><%= student.getFirstname() + " " + student.getLastname()%></div>
                        <div class="col col-2" data-label=""><%= student.getMajor() %></div>
                        <div class="col col-3" data-label=""><%= student.getGroup() %></div>
                        <div class="col col-4" data-label=""><%= student.getYear() %></div>
                        <div class="col col-5" data-label="">
                            <form method="post" action="<%=request.getContextPath()%>/StudentsServlet">
                                <th>
                                    <input style="display: none;" name="student_id" value="<%=student.getId()%>">
                                    <button style="width: 50% ;background-color: #95A5A6; border:#95A5A6;" class="btn btn-info mt-0" id="change8">Info</button>
                                </th>
                            </form>
                        </div>
                        <% } %>
                    </li>
                </ul>
            </div>
        </div>
    </li>


</ul>




<script src="${pageContext.request.contextPath}/js/filtermajor.js"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Райымбек
  Date: 15.11.2020
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Events Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Events Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Events</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${events != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${events == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${events!= null}">
                                Edit Events
                            </c:if>
                            <c:if test="${events == null}">
                                Add New Events
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${events != null}">
                        <input type="text" name="id" value="<c:out value='${events.id}' />" />
                    </c:if>


                    <fieldset class="form-group">
                        <label>Event Name</label> <input type="text" value="<c:out value='${event.name}' />" class="form-control" name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Event Description</label> <input type="text" value="<c:out value='${event.description}' />" class="form-control" name="description">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Event Date</label> <input type="text" value="<c:out value='${event.date}' />" class="form-control" name="date">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>

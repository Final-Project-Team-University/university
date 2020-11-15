<%--
  Created by IntelliJ IDEA.
  User: Райымбек
  Date: 15.11.2020
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>News Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> News Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">News</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${news != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${news == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${news != null}">
                                Edit News
                            </c:if>
                            <c:if test="${news == null}">
                                Add New News
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${news != null}">
                        <input type="text" name="id" value="<c:out value='${news.id}' />" />
                    </c:if>


                    <fieldset class="form-group">
                        <label>News Title</label> <input type="text" value="<c:out value='${news.title}' />" class="form-control" name="title" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>News Content</label> <input type="text" value="<c:out value='${news.content}' />" class="form-control" name="content">
                    </fieldset>



                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>

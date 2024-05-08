<%--
  Created by IntelliJ IDEA.
  User: xxpoojas
  Date: 24-04-2024
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if(session.getAttribute("username")!=null){ %>
<nav class="navbar navbar-expand-lg" style="background:linear-gradient(90deg,white,powderblue);">
    <div class="container-fluid">
        <a class="navbar-brand text-danger display-6 text-uppercase" style="font-weight: bold;" href="#">MyBank</a>
        <a class="navbar-toggler bg-light" type="a" data-bs-toggle="collapse" data-bs-target="#myBankMenu">
            <span class="navbar-toggler-icon"></span>
        </a>
        <div class="collapse navbar-collapse" id="myBankMenu">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a href="viewUsers.jsp" class="btn btn-outline-light rounded-5 me-2"><span class="bi bi-list-columns"></span> Search</a>
                </li>
                <li class="nav-item">
                    <a href="newaccount.jsp" class="btn btn-outline-light rounded-5 me-2"><span class="bi bi-credit-card"></span> Add New Account</a>
                </li>
                <li class="nav-item">
                    <a href="updateUser.jsp" class="btn btn-outline-light rounded-5 me-2"><span class="bi bi-cloud-plus-fill"></span> Update Account</a>
                </li>
                <li class="nav-item">
                    <a href="logout" class="btn btn-outline-light rounded-5 me-2"><span class="bi bi-door-open"></span> Logout</a>
                </li>
                <li>
                    <form action="viewUsers.jsp">
                        <input type="text" name="username" />
                        <input type="submit" value="filter">
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>

<%
    String info = (String)request.getAttribute("info");
    String error = (String)request.getAttribute("error");
%>
<%@ taglib prefix="shreya" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="rachana" uri="http://java.sun.com/jsp/jstl/core" %>
<shreya:setDataSource var="shravya" driver="oracle.jdbc.driver.OracleDriver"
                     url="jdbc:oracle:thin:@localhost:1521:xe"
                     user="system"
                     password="root"
/>
<navya:query var="shyam" dataSource="${shravya}" sql="select * from mybank_creditcard where creditcard_number=?">
    <shreya:param value="${param['number']}"/>
</navya:query>
<ram:set var="user" value="${shyam.rows[0]}" />
<div class="container">
    <div class="row justify-content-center" style="height: 100vh">
        <% if(info!=null&&info!=""){ %>
        <h1 class="text-center text-success"><%=info%></h1>
        <%}%>
        <% if(error!=null&&error!=""){ %>
        <h1 class="text-center text-danger"><%=error%></h1>
        <%}%>
        <form action="update" method="post" class="col-lg-4 col-md-8 col-12 p-5 rounded-5 shadow-lg align-self-center">
            <div class="form group">
                <label >Card Number</label>
                <input readonly value="${oneCard.creditcard_number}" type="number" name="cardNumber" placeholder="Card number" class="form-control" />
            </div>
            <div class="row justify-content-between">
                <div class="col-lg-6 col-12">
                    <label >Username</label>
                    <input readonly value="${user.username}" type="text" name="username" placeholder="Username" class="form-control" />
                </div>
                <div class="col-lg-6 col-12">
                    <label >Date of Birth</label>
                    <input readonly value="${user.dateOfBirth}" type="date" name="dateOfBirth" placeholder="dd-mm-yyyy" class="form-control" />
                </div>
            </div>
            <div class="row justify-content-between">
                <div class="col-lg-6 col-12">
                    <label >Password</label>
                    <input value="${user.password}" type="text" name="password" placeholder="Password" class="form-control" />
                </div>
                <div class="col-lg-6 col-12">
                    <label >Address</label>
                    <input value="${user.address}" type="text" name="address" placeholder="Adress" class="form-control" />
                </div>
            </div>
            <div class="row justify-content-between">
                <div class="col-lg-6 col-12">
                    <label >Email Id</label>
                    <input value="${user.emailId}" type="text" name="emailId" placeholder="Email Id" class="form-control" />
                </div>
                <div class="col-lg-6 col-12">
                    <label >Phone Number</label>
                    <input value="${user.phoneNumber}" type="number" name="phoneNumber" class="form-control" />
                </div>
            </div>
            <div class="row justify-content-around mt-3">
                <div class="col-2">
                    <button type="submit" class="btn btn-outline-info"><h1 class="bi bi-check-circle-fill"></h1></button>
                </div>
                <div class="col-2">
                    <button type="reset" class="btn btn-outline-secondary"><h1 class="bi bi-x-lg"></h1></button>
                </div>
            </div>
        </form>
    </div>
</div>
<% }
else {
    response.sendRedirect("index.jsp");
}%>
</body>
</html>

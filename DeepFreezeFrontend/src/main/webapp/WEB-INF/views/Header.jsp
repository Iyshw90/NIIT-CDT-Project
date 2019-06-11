<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>DeepFreeze</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--  <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	


<style type="text/css">
nav {
	margin: 0 auto;
	background: #fff;
	padding: 50px 0;
	box-shadow: 0px 5px 0px #dedede;
}
.navbar {
    border-radius: 4px;
}
nav ul li {
	display: inline-block;

}

.navbar .navbar-nav>li>a:hover, .navbar .navbar-nav>li>a:focus ,a>span.glyphicon:focus ,a>span.glyphicon:hover{
	color: #33adff !important;
	background-color: white;
}

.glyphicon{
color:white;
}
</style>

</head>


<body>

<div class="container-fluid">
	<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
	
		<div class="container-fluid">
		<ul class="nav navbar-nav">
			<!-- Brand/logo -->
			<a class="navbar-brand" href="#"> <img 	src="<c:url value="/resources/images/static/Logo.jpg" />" alt="logo_deepFreeze" style="width: 60px; height: 30px;">
			</a>
		
			<c:if test="${!sessionScope.loggedIn}">
			
				<li class="nav-item active"><a class="nav-link" href="index.jsp"> Home</a></li>
				<li class="nav-item active"><a class="nav-link" href="<c:url value="/aboutUs"/>"> About Us</a></li>
			</c:if>
			
			<c:if test="${sessionScope.loggedIn}">
				<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
					
					<li class="nav-item active"><a class="nav-link" href="<c:url value="/AdminHome"/>"> Home</a></li>
					<li class="nav-item active"><a class="nav-link" href="<c:url value="/category"/>"> Category Management</a></li>
					<li class="nav-item active"><a class="nav-link" href="<c:url value="/supplier"/>"> Supplier Management</a></li>
					<li class="nav-item active"><a class="nav-link" href="<c:url value="/product"/>"> Product Management</a></li>
				</c:if>
				<c:if test="${sessionScope.role=='ROLE_USER'}">
					<li class="nav-item active"><a class="nav-link" href="index.jsp"> Home</a></li>
					<li class="nav-item active"><a class="nav-link" href="<c:url value="/aboutUs"/>"> About Us</a></li>
					<li class="nav-item active"><a class="nav-link" href="<c:url value="/productsPage"/>">All Products</a></li>
					<li class="nav-item active"><a class="nav-link" href="<c:url value="/showCart"/>"> My Cart</a></li>
				</c:if>
						
			</c:if>
		</ul>
		
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${!sessionScope.loggedIn}">
				<li class="nav-item active"><a class="nav-link" href="<c:url value="/login"/>">
				<span class="glyphicon glyphicon-log-in" ></span>
						Login</a></li>
				<li class="nav-item active"><a class="nav-link" href="<c:url value="/register"/>" >
				<span class="glyphicon glyphicon-user" ></span>
						Sign Up</a></li>
			</c:if>
			
			<c:if test="${sessionScope.loggedIn}">
				<li class="nav-item active"><a class="nav-link" href="#">
				<span class="glyphicon glyphicon-user" >${sessionScope.username}</span>
						</a></li>
				<li class="nav-item active"><a class="nav-link" href="<c:url value="/perform_logout"/>" >
				<span class="glyphicon glyphicon-log-out" ></span>
						Logout</a></li>
			</c:if>
			
		</ul>

	</div>
		
	</nav>

</div>
</body>
</html>
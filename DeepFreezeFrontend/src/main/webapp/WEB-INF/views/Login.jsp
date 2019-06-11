<%@ include file="Header.jsp"%>

<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style type="text/css">
.col-sm img{
 border-radius: 4px;
  padding: 5px;
}
.col-sm form{
border-radius: 5px;
  padding: 80px;
}
.col-sm h2{
border-radius: 10px;
  padding-top: 50px;
}
.bgColor{
	background-color:#deeaee;
}

.loginButton{
padding-top: 10px !important;
}

td.checkbox{

float:right !important;
}
tr.form-check {
position:relative;
display:contents;
padding-left:0rem;
}

</style>
</head>

<body>
	 <div class="container-fluid">
	 <div class="row">
				<div class="col-sm">
					<img src="<c:url value="/resources/images/static/DF_Login_Logo.jpg" />"
						
						class="rounded float-left" alt="Login_Logo"
						style="width: 100%; height: 90%;">
				</div>
			
				<div class="col-sm">
					<h2><center>Login</center></h2>
					<form action="perform_login" method="post">
						<table align="center">
							<tr class="form-group">
								

								<td><label for="username">Username:</label></td>
								<td><input type="text" class="form-control" id="username"
									placeholder="Enter Username" name="username"></td>
									
							</tr>
							<tr class="form-group">

								<td><label for="pwd">Password:</label></td>
								<td><input type="password" class="form-control" id="password"
									placeholder="Enter password" name="password"></td>
							</tr>
							<!--  <tr class="form-group form-check">
							<td></td>
								<td class="checkbox"><label class="form-check-label"> <input
										class="form-check-input" type="checkbox" name="remember">
										Remember me
								</label></td>
							</tr>-->
							<tr><td></td><td></td></tr>
							<tr><td></td><td></td></tr>
							<tr><td></td><td></td></tr>
							<tr><td></td><td></td></tr>
							<tr><td></td><td></td></tr>
													
							<tr class="loginButton">
							<td></td>
							
								<td>
									<div class="col-md-4 text-center">
									<input type="submit" value="  Login  " class="btn btn-primary center-block"/>
									</div>
								</td>
							</tr>
						</table>
					</form>
				</div>

</div>			
</div>

<!-- Footer section starts -->
<br><br>
<article class="bgColor mb-2">  
<div class="card-body text-center">
    <h3 class="text-black mt-3">DEEP FREEZE</h3> 
<p class="h5 text-b;ack"> <h5>World of Refrigerator's </h5> <h6>choose your unique style of cooling and keep it cool </h6> </p>   <br>
<p><a class="btn btn-info" target="_blank" href="<c:url value="/aboutUs"/>"> © 2007-2019 Deepfreeze.com  
 <i class="fa fa-window-restore "></i></a></p>
</div>
<br><br>
</article>
</body>
</html>
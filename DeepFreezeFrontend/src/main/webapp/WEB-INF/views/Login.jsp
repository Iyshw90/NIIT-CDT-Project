<%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
					<form action="#">
						<table align="center">
							<tr class="form-group">
								

								<td><label for="email">Email:</label></td>
								<td><input type="email" class="form-control" id="email"
									placeholder="Enter email" name="email"></td>
									
							</tr>
							<tr class="form-group">

								<td><label for="pwd">Password:</label></td>
								<td><input type="password" class="form-control" id="pswd"
									placeholder="Enter password" name="pswd"></td>
							</tr>
							<tr class="form-group form-check">
							<td></td>
								<td class="checkbox"><label class="form-check-label"> <input
										class="form-check-input" type="checkbox" name="remember">
										Remember me
								</label></td>
							</tr>
							<tr>
								<td>
									<div class="col-md-4 text-center">
									<button type="submit" class="btn btn-primary center-block">Submit</button>
									</div>
								</td>
							</tr>
						</table>
					</form>
				</div>

</div>			
</div>
</body>
</html>
<%@ include file="Header.jsp"%>

<html>
<head>
<meta charset="utf-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Register</title>

<style type="text/css">


.bgColor{
	background-color:#deeaee;
}

.divider-text {
    position: relative;
    text-align: center;
    margin-top: 15px;
    margin-bottom: 15px;
}
.divider-text span {
    padding: 7px;
    font-size: 12px;
    position: relative;   
    z-index: 2;
}
.divider-text:after {
    content: "";
    position: absolute;
    width: 100%;
    border-bottom: 1px solid #ddd;
    top: 55%;
    left: 0;
    z-index: 1;
}

.btn-facebook {
    background-color: #405D9D;
    color: #fff;
}
.btn-twitter {
    background-color: #42AEEC;
    color: #fff;
}
</style>
</head>
<body>
<div class="container">
<br> 


<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Create Account</h4>
	<p class="text-center">Get started with your free account</p>
	<p>
		<a href="https://twitter.com/login?lang=en" class="btn btn-block btn-twitter"> <i class="fab fa-twitter"></i>   Login via Twitter</a>
		<a href="https://www.facebook.com/" class="btn btn-block btn-facebook"> <i class="fab fa-facebook-f"></i>   Login via facebook</a>
	</p>
	<p class="divider-text">
        <span class="bg-light">OR</span>
    </p>
	<form action="<c:url value="/RegisterUser" />" method="post">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="customername" pattern="[A-Za-z]{2,30}" title="Enter valid name" class="form-control" placeholder="Full name" type="text" required>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="username" pattern="[A-Za-z0-9]{3,15}" title="Username name can contain only Alphabets and numbers" class="form-control" placeholder="User name" type="text" required>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="Enter valid Email Id" class="form-control" placeholder="Email address" type="email" required>
    </div> <!-- form-group// -->
   
    
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" class="form-control" placeholder="Create password" type="password" required>
    </div> <!-- form-group// 
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" placeholder="Repeat password" type="password" required>
    </div>--> <!-- form-group// -->    
     <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="address" pattern="[a-zA-Z0-9\s\.\,]+" title="Enter valid address" class="form-control" placeholder="Address" type="text" required>
    </div> <!-- form-group// -->                                  
    <div class="form-group">
        <input type="submit" value="Create Account" class="btn btn-primary btn-block" />  
    </div> <!-- form-group// -->      
    <p class="text-center">Have an account? <a href="<c:url value="/login"/>">Log In</a> </p>                                                                 
</form>
</article>
</div> <!-- card.// -->
</div> 
<!--container end.//-->

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
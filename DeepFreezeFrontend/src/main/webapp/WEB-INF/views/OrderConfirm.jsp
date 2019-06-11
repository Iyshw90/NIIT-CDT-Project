<%@ include file="Header.jsp"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Ordered Item</title>

<style type="text/css">
.edit{
	float:right;
	text-align: right ! important;
	display:block ! important; 
}

.payment{
	 float:right;
     text-align: right ! important; 
     display:block ! important; 
}

</style>

</head>
<body>

<div class="container">

<section class ="text-center">
	<div class="container">
		<a class="navbar-brand" href="#"> <img 	src="<c:url value="/resources/images/static/Logo.jpg" />" alt="logo_deepFreeze" style="width: 60px; height: 30px;">
			</a>
	</div>
</section>

<div class="container mb-4">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                    	<th scope="col"></th>
                    	<th scope="col">Products</th>
                        <th scope="col">Available</th>
                        <th scope="col" class="text-center">Quantity</th>
                        <th scope="col" class="text-center">Price</th>
                        <th scope="col" class="text-center">Total Price</th>
                        <th></th>
                        
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${cartItems}" var="cartItem">
                <form action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>" method="get">
                   <tr>
                    <td><img class="img-fluid img-thumbnail thumbnailSize" src="<c:url value="/resources/images/${cartItem.prodId}.jpg"/>" width="50" height="50"></td>
                    <td>${cartItem.productName}</td>
                    <td>In Stock</td>
                    <td>${cartItem.quantity}</td>
                    
                    <td class="text-right" >${cartItem.price}</td>
                    <td class="text-right" >${cartItem.price * cartItem.quantity}</td>
                    
                   
                      
                    </tr>
                    </form>
                    </c:forEach>
                    
                    <tr>
                    	<td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Subtotal</h5></td>
                        <td class="text-right"><strong>INR. ${grandTotal} /- </strong></td>
                    </tr>
                   
                    <tr>
                    <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h5><strong>INR. ${grandTotal} /-</strong></h5></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col mb-2 ">
    	<div class="row ">
    		<div class="col-sm-6 col-md-3  ">
    		<a href="<c:url value="/showCart" />" class="btn  btn-info edit" >Edit Cart</a>
    		</div>
    		<div class="col-sm-6 col-md-3  ">
    		<a href="<c:url value="/paymentPage"/>" class="btn  btn-info payment " >Payment</a>
    		</div>
    	</div>
  </div>
<br/>  
<hr>    
<br/>   
    <div class="col mb-2">
    <form action="<c:url value="/updateAddress"/>" method="post">
    
    	<div class="row">
    		<div class="col-sm-2 col-xs-12 col-md-2">
    			<label id="addr"> Address</label>
    		</div>
    		<div class="col-sm-8 cols-xs-12 col-md-6">
    			<textarea rows="3" cols="40" name="addr">${addr}</textarea>
    		</div>
    		<div class="col-sm-2 col-xs-12 col-md-2">
    			<input type="submit" value="Update Address" class="btn  btn-info">
    		</div>
    	</div>
    	
    </form>	
    </div>
    
    
</div>
</div>
</body>
</html>
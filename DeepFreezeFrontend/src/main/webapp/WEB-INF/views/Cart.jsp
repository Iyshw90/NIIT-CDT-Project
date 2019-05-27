<%@ include file="Header.jsp"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>

<div class="container">
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
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${cartItems}" var="cartItem">
                <form action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>" method="get">
                   <tr>
                    <td><img src="<c:url value="/resources/images/${cartItem.productId}.jsp"/>" ></td>
                    <td>${cartItem.productName}</td>
                    <td>In Stock</td>
                    <td><input class="form-control" type="text" name="quantity" value="${cartItem.quantity}"/></td>
                    <td class="text-right" >${cartItem.price}</td>
                    <td class="text-right" >${cartItem.price * cartItem.quantity}</td>
                     <td class="text-right" >
                     	<input type="submit" value="Update" class="btn btn-info"/>
                     	<a href="<c:url value="/deleteCartItem/${cartItem.cartItemId}" />" class="btn btn-danger"> Delete</a> 
                     </td>
                   
                      
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
    	<div class="row">
    		<div class="col-sm-6 col-md-3">
    			<button class="btn btn-block btn-info btn-sm float-right"> Continue Shopping</button>
    		</div>
    		<div class="col-sm-6 col-md-3 text-right float-right">
    			<button class="btn btn-block btn-info btn-sm float-right" > Checkout</button>
    		</div>
    	</div>
    </div>
</div>

</body>
</html>
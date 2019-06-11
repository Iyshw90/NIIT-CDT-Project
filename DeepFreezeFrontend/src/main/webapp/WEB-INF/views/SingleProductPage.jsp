<%@ include file="Header.jsp" %>
<html>
<head>
<style type="text/css">


.gold{
	color: #FFBF00;
}


.product{
	border: 1px solid #dddddd;
	height: 321px;
}

.product>img{
	max-width: 100%;
}

.product-rating{
	font-size: 20px;
	margin-bottom: 25px;
}

.product-title{
	font-size: 20px;
}

.product-desc{
	font-size: 14px;
}

.product-price{
	font-size: 22px;
}

.product-stock{
	color: #74DF00;
	font-size: 20px;
	margin-top: 10px;
}

.product-info{
		margin-top: 50px;
}


.content-wrapper {
	max-width: 1140px;
	background: #fff;
	margin: 0 auto;
	margin-top: 25px;
	margin-bottom: 10px;
	border: 0px;
	border-radius: 0px;
}

.container-fluid#conFluid{
	max-width: 1140px;
	margin: 0 auto;
}

.view-wrapper {
	float: right;
	max-width: 100%;
	margin-top: 25px;
}

.container#cont {
	float:left;
	padding-left: 0px;
	padding-right: 0px;
	max-width: 50%;
}

.container#contRight{
	float:right !important;
	padding-left: 0px;
	padding-right: 0px;
	max-width: 50%;
}




</style>
</head>




<body>

<div class="container-fluid" id="conFluid">
    <div class="content-wrapper">	
		<div class="item-container">	
			<div class="container" id="cont">	
				<div class="col-md-12">
					<div class="product service-image-left">
                    
						<center>
							<img id="item-display" src="<c:url value="/resources/images/${product.prodId}.jpg"/>" alt="" width="500" height="500" />
						</center>
					</div>
					
				</div>
			</div>
			<div class="container" id="contRight">	
				<form action="<c:url value="/addToCart/${product.prodId}" />" method="get">
				<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12 ">
					<div class="product-title">${product.prodName}</div>
					<div class="product-desc">${product.prodDesc}</div>
					<hr>
					<div class="product-price">INR ${product.price}</div>
					<div class="product-stock">In Stock</div>
					<div class="product-price" >Quantity
						<select name="quantity">
							<option value="1" > 1</option>
							<option value="2" > 2</option>
							<option value="3" > 3</option>
													
						</select>
					</div>
					<hr>
					<div class="btn-group cart">
					
						<input type="submit" value="Add to cart" class="btn btn-success" />
							
						
					</div>
					<!--  <div class="btn-group wishlist">
						<a href="<c:url value="/checkout"/>" class="btn btn-block btn-danger" > Buy Now</a>
						
					</div>-->
				</div>
				
				</form>	
			</div> 
		</div>
		
	</div>
</div>



</body>
</html>
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
	max-width: 230px;
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
	max-width: 70%;
	margin-top: 25px;
}

.container#cont {
	padding-left: 0px;
	padding-right: 0px;
	max-width: 100%;
}


.service-image-left {
	padding-right: 50px;
}

.service-image-left > center > img,.service-image-right > center > img{
	max-height: 155px;
}

</style>
</head>




<body>

<div class="container-fluid" id="conFluid">
    <div class="content-wrapper">	
		<div class="item-container">	
			<div class="container" id="cont">	
				<div class="col-md-12">
					<div class="product col-md-3 service-image-left">
                    
						<center>
							<img id="item-display" src="<c:url value="/resources/images/${product.prodId}.jpg"/>" alt=""/>
						</center>
					</div>
					
				</div>
					
				<form action="<c:url value="/addToCart/${product.prodId}" />" method="get">
				<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
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
							<option value="4" > 4</option>
							<option value="5" > 5</option>
						
						</select>
					</div>
					<hr>
					<div class="btn-group cart">
					
						<input type="submit" value="Add to cart" class="btn btn-success">
							
						</button>
					</div>
					<div class="btn-group wishlist">
						<button type="button" class="btn btn-danger">
							Buy Now 
						</button>
					</div>
				</div>
				
				</form>	
			</div> 
		</div>
		
	</div>
</div>



</body>
</html>
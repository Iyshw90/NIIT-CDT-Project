<%@ include file="Header.jsp"%>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
.container {
	padding: 10px;
}

.thumbnailSize {
	width: 50%;
	height: 23% ! important;
	display: inline-block; /* makes it fit in like an <img> */
	background-size: cover; /* or contain */
	background-position: center center;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row text-center text-lg-left">
			<c:forEach items="${productList}" var="product">
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
					<c:if test="${product.stock > 0 }">
						<a href="<c:url value="/singleProductDisplay/${product.prodId}"/>" 	class="d-block mb-4 h-100"> 
							<img class="img-fluid img-thumbnail thumbnailSize" src="<c:url value="/resources/images/${product.prodId}.jpg"/>"
							width="100" height="100" />
						</a>
					</c:if>

					<p>Price: ${product.price}</p>
					<p>
						Stock:
						<c:if test="${product.stock >0  }">${product.stock}</c:if>
						<c:if test="${product.stock <=0 }">
							<font color="red">Out Of Stock</font>
						</c:if>
					</p>

					<p>
					<h4>${product.prodName}</h4>
					</p>


				</div>

			</c:forEach>


		</div>



	</div>

</body>
</html>
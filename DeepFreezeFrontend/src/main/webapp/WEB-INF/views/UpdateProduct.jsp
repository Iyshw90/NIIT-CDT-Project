<%@ include file="Header.jsp" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
</head>
<body>
<c:url var="update_url"  value="/UpdateProduct" />
<form:form action="${update_url}" modelAttribute="product" method="post">
<table align="center">
	<tr>
		<td>Product Management</td>
	</tr>
	<tr>
		<td>Product Id
		</td>
		<td><form:input path="prodId" value="${product.prodId}" readonly="true"/></td>
		
	</tr>
	<tr>
		<td> Product Name </td>
		<td><form:input path="prodName" value="${product.prodName}"/></td>
	</tr>
	<tr>
		<td> Product Description </td>
		<td><form:input path="prodDesc" value="${product.prodDesc}"/></td>
	</tr>
	<tr>
		<td>Stock </td>
		<td><form:input path="stock" value="${product.stock}"/></td>
	</tr>
	<tr>
		<td> Price </td>
		<td><form:input path="price" value="${product.price}"/></td>
	</tr>
	<tr>
		<td>Category </td>
		<td>
			<form:select path="catId">
				<form:option value="0" label="--Select Category--"/>
				<form:options items="${categoryList}" />
				
			</form:select>
		
		</td>
	</tr>
	<tr>
		<td>Supplier </td>
		<td>
			<form:select path="supId">
				<form:option value="0" label="--Select Supplier--"/>
				<form:options items="${supplierList}" />
				
			</form:select>
		
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Update Product"/>
		</td>
	</tr>

</table>
</form:form>

<br/><br/>
<table align="center">
	<tr bgcolor="lightblue">
		<td>Product Name</td>
		<td>Stock</td>
		<td>Price</td>
		<td>Category</td>
		<td>Supplier</td>
		
	</tr>
	<c:forEach items="${productList}" var="product">
		<tr>
			<td>${product.prodName}</td>
			<td>${product.stock}</td>
			<td>${product.price}</td>
			<td>${product.catId}</td>
			<td>${product.supId}</td>
			<td>
			<!-- on click of the link this particular 'value' will go in url and the mapping happens to the corresponding controller method() -->
					<a href="<c:url value="/editProduct/${product.prodId}"/>"> Edit</a>
					<a href="<c:url value="/deleteProduct/${product.prodId}"/>"> Delete</a>
		</tr>
	
	</c:forEach>
	

</table>
</body>
</html>
<%@ include file="Header.jsp" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>

<style type="text/css">
#tableHeading{
text-align:center;
}
table#insertTable {
  table-layout: fixed ;
  width: 100% ;
}
td#equalCol {
  width: 50% ;
}

</style>

<script type="text/javascript">

function resetValues()
{
	document.getElementById("myStock").value = "";
	document.getElementById("myPrice").value = "";
}
function validateForm(){
	if( document.getElementById('categoryIdSelect').value === '0')   
	  {
	    alert("Need to select any category");
	   return false;
	  }
	  else if(document.getElementById('supplierIdSelect').value === '0' )
	  {
		    alert("Need to select any Supplier");
		   return false;
	   }
	  return true;
	}
</script>
</head>

<body onload="resetValues()">

<div class="container">

<c:url var="insert_url"  value="/InsertProduct" />
<form:form action="${insert_url}" modelAttribute="product" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
<table id="insertTable" align="center" class="table table-striped table-hover table-condensed">
	<thead>
	<tr>
		<th id="tableHeading" colspan="2" >Product Management</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td id="equalCol" align="right"> Product Name </td>
		<td id="equalCol"><form:input path="prodName" required="true" /></td>
	</tr>
	<tr>
		<td id="equalCol" align="right"> Product Description </td>
		<td id="equalCol"><form:input path="prodDesc" required="true"/></td>
	</tr>
	
	<tr>
		<td id="equalCol" align="right">Stock </td>		
	 <td id="equalCol"><form:input id="myStock" path="stock" required="true" /></td>
	</tr>
	<tr>
		<td id="equalCol" align="right"> Price </td>
		<td id="equalCol"><form:input id="myPrice" path="price" required="true" /></td>
	</tr>
	<tr>
		<td id="equalCol" align="right">Category </td>
		<td id="equalCol">
			<form:select id="categoryIdSelect" path="catId" required="true">  
				<form:option value="0" label="--Select Category--"/>
				<form:options items="${categoryList}" />
				
			</form:select>
		
		</td>
	</tr>
	<tr>
		<td id="equalCol" align="right">Supplier </td>
		<td id="equalCol">
			<form:select id="supplierIdSelect" path="supId" required="true">
				<form:option value="0" label="--Select Supplier--"/>
				<form:options items="${supplierList}" />
				
			</form:select>
		
		</td>
	</tr>
	<tr>
		<td id="equalCol"align="right">Product Image</td>
		<td id="equalCol"><form:input type="file" path="pimage" required="true"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<center>
			<input type="submit" value="Insert Product" class="btn btn-info"/>
			</center>
		</td>
	</tr>
	</tbody>
</table>
</form:form>

<br/><br/>
<table align="center" class="table table-info table-striped table-condensed table-hover">
	<tr >
		<th >Product Name</th>
		<th id="tableHeading">Stock</th>
		<th id="tableHeading">Price</th>
		<th id="tableHeading">Category</th>
		<th id="tableHeading">Supplier</th>
		<th id="tableHeading">Operations</th>
		
	</tr>
	<c:forEach items="${productList}" var="product">
		<tr>
			<td>${product.prodName}</td>
			<td align="center">${product.stock}</td>
			<td align="center">${product.price}</td>
			<td align="center">${product.catId}</td>
			<td align="center">${product.supId}</td>
			<td align="center">
			<!-- on click of the link this particular 'value' will go in url and the mapping happens to the corresponding controller method() -->
					<a  href="<c:url value="/editProduct/${product.prodId}"/>"> 
					<img src="<c:url value="/resources/images/static/Edit_Icon.jpg" />" width="30" height="30"/>
					</a>
					<a  href="<c:url value="/deleteProduct/${product.prodId}"/>"> 
					<img src="<c:url value="/resources/images/static/Delete_Icon.jpg" />" width="30" height="27.5"/>
					</a>
		</tr>
	
	</c:forEach>

</table>

</div>
</body>
</html>
<%@ include file="Header.jsp"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Supplier</title>

<style type="text/css">
#tableHeading{
text-align:center;
}
</style>

</head>
<body>

<div class="container">
<form action="<c:url value="/UpdateSupplier" />" method="post">
<table align="center" class="table table-striped table-hover table-condensed">
	<thead>
	<tr>
		<th id="tableHeading" colspan="2" >Edit Supplier</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td align="right">Supplier Id </td>
		<td> <input type="text" name="supplierId" value="${supplier.supId}" readonly/></td>
	</tr>
	<tr>
		<td align="right">Supplier Name </td>
		<td> <input type="text" name="supplierName" value="${supplier.supName}" required/></td>
	</tr>
	<tr>
		<td align="right">Supplier Address </td>
		<td> <input type="text" name="supplierAddr" value="${supplier.supAddr}" required/></td>
	</tr>
	<tr>
	<td colspan="2">
		<center> 
			<input type="submit" value="Update Supplier" class="btn btn-info">
		</center>
	</td>
	</tr>
	</tbody>
</table>

</form>

<br><br>

<!--  <table align="center">
	<tr>
		<th> SL# </th>
		<th> Supplier Name</th>
		<th> Supplier Address</th>
		<th> Operations</th>
	</tr>
	<c:forEach items="${supplierList}" var="supplier">
	<tr>
		<td> ${supplier.supId}</td>
		<td> ${supplier.supName}</td>
		<td> ${supplier.supAddr}</td>
		<td align="center">
			<a  href="<c:url value="/editSupplier/${supplier.supId}"/>"> 
			<img src="<c:url value="/resources/images/static/Edit_Icon.jpg" />" width="30" height="30"/>
			</a>
			<a  href="<c:url value="/deleteSupplier/${supplier.supId}"/>"> 
			<img src="<c:url value="/resources/images/static/Delete_Icon.jpg" />" width="30" height="27.5"/>
			</a>
		</td>
		
	</tr>
	</c:forEach>
			
</table>-->


</div>
</body>
</html>
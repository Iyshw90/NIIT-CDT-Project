<%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Supplier</title>
</head>
<body>
<form action="<c:url value="/UpdateSupplier" />" method="post">
<table align="center">
	<tr>
		<td colspan="2">Supplier Management</td>
	</tr>
	<tr></tr>
	<tr>
		<td>Supplier Id </td>
		<td> <input type="text" name="supplierId" value="${supplier.supId}" readonly/></td>
	</tr>
	<tr>
		<td>Supplier Name </td>
		<td> <input type="text" name="supplierName" value="${supplier.supName}" /></td>
	</tr>
	<tr>
		<td>Supplier Address </td>
		<td> <input type="text" name="supplierAddr" value="${supplier.supAddr}" /></td>
	</tr>
	<tr>
	<td colspan="2">
		<center> 
			<input type="submit" value="Update Supplier">
		</center>
	</td>
	</tr>
</table>

</form>

<br><br>
<table align="center">
	<tr>
		<td> SL# </td>
		<td> Supplier Name</td>
		<td> Supplier Address</td>
		<td></td>
	</tr>
	<c:forEach items="${supplierList}" var="supplier">
	<tr>
		<td></td>
		<td> ${supplier.supName}</td>
		<td> ${supplier.supAddr}</td>
		<td>
			<a href="<c:url value="/editSupplier/${supplier.supId}"/>"> Edit</a>
			<a href="<c:url value="/deleteSuppplier/${supplier.supId}"/>"> Delete</a>
		</td>
	</tr>
	</c:forEach>
			
</table>
</body>
</html>
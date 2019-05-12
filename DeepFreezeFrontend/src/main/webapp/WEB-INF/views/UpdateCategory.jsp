<%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Category</title>
</head>
<body>

<form action="<c:url value="/UpdateCategory" />" method="post">
<table align="center">
	<tr>
		<td colspan="2">Category Management</td>
	</tr>
	<tr></tr>
	<tr>
		<td>Category Id </td>
		<td> <input type="text" name="categoryId" value="${category.catId}" readonly/></td>
	</tr>
	<tr>
		<td>Category Name </td>
		<td> <input type="text" name="categoryName" value="${category.catName}" /></td>
	</tr>
	<tr>
		<td>Category Description </td>
		<td> <input type="text" name="categoryDesc" value="${category.catDesc}" /></td>
	</tr>
	<tr>
	<td colspan="2">
		<center> 
			<input type="submit" value="Update Category">
		</center>
	</td>
	</tr>
</table>

</form>

<br><br>
<table align="center">
	<tr>
		<td> SL# </td>
		<td> Category Name</td>
		<td> Category Description</td>
		<td></td>
	</tr>
	<c:forEach items="${categoryList}" var="category">
	<tr>
		<td></td>
		<td> ${category.catName}</td>
		<td> ${category.catDesc}</td>
		<td>
			<a href="<c:url value="/editCategory/${category.catId}"/>"> Edit</a>
			<a href="<c:url value="/deleteCategory/${category.catId}"/>"> Delete</a>
		</td>
	</tr>
	</c:forEach>
			
</table>
</body>
</html>
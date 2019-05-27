<%@ include file="Header.jsp"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Category</title>

<style type="text/css">
#tableHeading{
text-align:center;
}

</style>

</head>
<body>
<div class="container">

<form action="<c:url value="/UpdateCategory" />" method="post">
<table align="center" class="table table-striped table-hover table-condensed">
	<thead>
	<tr>
		<th id="tableHeading" colspan="2" >Edit Category </th>
	</tr>
	</thead>
	<tbody>
	
	<tr>
		<td align="right">Category Id </td>
		<td> <input type="text" name="categoryId" value="${category.catId}" readonly/></td>
	</tr>
	<tr>
		<td align="right">Category Name </td>
		<td> <input type="text" name="categoryName" value="${category.catName}" required/></td>
	</tr>
	<tr>
		<td align="right">Category Description </td>
		<td> <input type="text" name="categoryDesc" value="${category.catDesc}" required/></td>
	</tr>
	<tr>
	<td colspan="2">
		<center> 
			<input type="submit" value="Update Category" class="btn btn-info">
		</center>
	</td>
	</tr>
	</tbody>
</table>

</form>

<br><br>

<!--<table align="center">
	<tr>
		<th> SL# </th>
		<th> Category Name</th>
		<th> Category Description</th>
		<th> Operations</th>
	</tr>
	<c:forEach items="${categoryList}" var="category">
	<tr>
		<td> ${category.catId}</td>
		<td> ${category.catName}</td>
		<td> ${category.catDesc}</td>
		<td align="center">
		
			<a  href="<c:url value="/editCategory/${category.catId}"/>"> 
			<img src="<c:url value="/resources/images/static/Edit_Icon.jpg" />" width="30" height="30"/>
			</a>
			<a  href="<c:url value="/deleteCategory/${category.catId}"/>"> 
			<img src="<c:url value="/resources/images/static/Delete_Icon.jpg" />" width="30" height="27.5"/>
			</a>
		</td>
	</tr>
	</c:forEach>
			
</table>-->


</div>
</body>
</html>
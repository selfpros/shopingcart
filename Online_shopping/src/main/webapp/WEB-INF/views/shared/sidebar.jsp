<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>
</head>
<body>
	<h1 class="my-4">Shop Name</h1>
	<div class="list-group">
		<c:forEach items="${categories}" var="category">
			<a href="${contextRoot}/show/category/${category.id}/products"
				class="list-group-item" id="a_${category.name}">${category.name}</a>
		</c:forEach>
	</div>

</body>
</html>
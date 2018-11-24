<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<ol class="breadcrumb">

					<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
					<li class="breadcrumb-item"><a
						href="${contextRoot}/show/all/products">Products</a></li>
					<li class="breadcrumb-item active">${products.name}</li>


				</ol>


			</div>


		</div>


		<div class="row">
			<div class=" col-xs-12 col-sm-4">
				<div class="thumbnail">
					<img src="${images}/${products.code}.jpg"
						class="img  img-responsive " />

				</div>



			</div>
			<div class=" col-xs-12 col-sm-8">

				<h3>${products.name}</h3>
				<hr />
				<P>${products. description}</P>
				<hr />
				<h4>
					price:<strong>&#8377;${products.unitPrice}</strong>
				</h4>
				<hr />
				
				<c:choose>
				
				<c:when test="${products.quantity < 1}">
				
					<h6>Qty. Available: <span style="color:red">Out of Stock!</span></h6>
					
				</c:when>
				<c:otherwise>				
					
					<h6>Qty. Available: ${products.quantity}</h6>
						
				</c:otherwise>
			
			</c:choose>
			<c:choose>
				
				<c:when test="${products.quantity < 1}">
				
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
					<i class="fa fa-shopping-cart" aria-hidden="true"></i>Add to Cart</strike></a>
					
				</c:when>
				<c:otherwise>				
				
				<a href="${contextRoot}/cart/add/${products.id}/product" class="btn btn-success">
				<i class="fa fa-shopping-cart" aria-hidden="true"></i>Add to Cart</a>
				
				</c:otherwise>
			
			</c:choose>
					


				<a href="${contextRoot}/show/all/products" class="btn btn-primary ">Back</a>
			</div>

		</div>



	</div>


</body>
</html>
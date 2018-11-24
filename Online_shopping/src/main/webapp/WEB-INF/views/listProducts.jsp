<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-md-3">

				<%@include file="./shared/sidebar.jsp"%>


			</div>
			<div class="col-md-9">
				<div class="row">
					<div class="col-lg-12">
						<c:if test="${userClickAllProducts==true}">
							<script>
								window.categoryId = '';
							</script>
							<ol class="breadcrumb">
								<li><a href="${contextRooot}/home">Home</a></li>
								<li class="active">All Products</li>
							</ol>
						</c:if>

						<c:if test="${userClickCategoryProducts==true}">
							<script>
								window.categoryId = '${category.id}';
							</script>

							<ol class="breadcrumb">
								<li><a href="${contextRooot}/home">Home</a></li>
								<li class="active">Category</li>
								<li class="active">${category.name}</li>

							</ol>
						</c:if>
					</div>
				</div>
				<div class="col-md-12">
					<table id="productsListTable"
						class="table table-stripped table-borderd">

						<thead>
							<tr>
								<th></th>
								<th>name</th>
								<th>brand</th>
								<th>quantity</th>
								<th>unitprice</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<!-- <tr>
								<th>name</th>
								<th>brand</th>
								<th>quantity</th>
							</tr> -->
						</tfoot>
					</table>
				</div>

			</div>

		</div>
	</div>
</body>
</html>
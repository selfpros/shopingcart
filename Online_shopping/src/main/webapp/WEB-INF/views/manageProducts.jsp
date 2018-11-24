
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>manage Products</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<c:if test="${not empty message}">


				<div class="col-xs-12">
					<div class="alert alert-success alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						${message}
					</div>
				</div>
			</c:if>

			<div class="col-xs-offset-4 col-md-8">
				<div class="card">
					<h2 class="card-header" style="text-align: center;">Manage
						Products</h2>
					<div class="card-body">
						<sf:form class="form-horizontal" modelAttribute="products"
							action="${contextRoot}/manage/products" method="POST"
							enctype="multipart/form-data">

							<div class="form-group row">
								<label class="col-sm-4 col-form-label">Enter Product
									Name</label>
								<div class="col-sm-8">
									<sf:input type="text" class="form-control" id="name"
										path="name" placeholder="Enter Product Name" />
									<sf:errors path="name" cssClass="help-block" element="em" />
								</div>
							</div>



							<div class="form-group row">
								<label class="col-sm-4 col-form-label">Enter Product
									Brand</label>
								<div class="col-sm-8">
									<sf:input type="text" class="form-control" id="brnad"
										path="brand" placeholder="Enter Product Brand" />
									<sf:errors path="brand" cssClass="help-block" element="em" />

								</div>
							</div>


							<div class="form-group row">
								<label class="col-sm-4 col-form-label">Product
									Description:</label>
								<div class="col-sm-8">
									<sf:textarea path="description" id="description" rows="4"
										cols="55" placeholder="Write a description"></sf:textarea>
									<sf:errors path="description" cssClass="help-block"
										element="em" />

								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-4 col-form-label">Enter Unit Price</label>
								<div class="col-sm-8">
									<sf:input type="number" class="form-control" id="unitprice"
										path="unitPrice" placeholder="Unit price in &#8377;" />
									<sf:errors path="unitPrice" cssClass="help-block" element="em" />

								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-4 col-form-label">Select an Image:</label>
								<div class="col-sm-8">
									<sf:input type="file" class="form-control" id="file"
										path="file" />
									<sf:errors path="file" cssClass="help-block" element="em" />
								</div>
							</div>


							<div class="form-group row">
								<label for="file" class="col-sm-4 col-form-label">Quantity
									Avilable:</label>
								<div class="col-sm-8">
									<sf:input type="number" class="form-control" id="quantity"
										path="quantity" placeholder="Quantity Avilable" />
								</div>
							</div>
							<div class="form-group row">
								<label for="name" class="col-sm-4 col-form-label">Select
									Category:</label>
								<div class="col-sm-8">
									<sf:select class="form-control" id="categoryId"
										path="categoryId" items="${categories}" itemLabel="name"
										itemValue="id" />





								</div>
							</div>



							<div class="form-group row">
								<div class="  col-sm-9">
									<input type="submit" id="submit" name="submit" value="Submit"
										class="btn btn-primary">


									<sf:hidden path="id" />
									<sf:hidden path="code" />
									<sf:hidden path="purchases" />
									<sf:hidden path="views" />
									<sf:hidden path="suplierid" />


								</div>
							</div>



						</sf:form>


					</div>
				</div>

			</div>
		</div>

	</div>
   
    <div class="container">
	<div class="col-xs-12">
		<h3>Avilable Products</h3>
		<hr />

	</div>
	<div class="col-xs-12">
		<div style="overflow: auto;">
			<table id="adminProductsTable"
				class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>&#160;Product</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Quantity</th>
						<th>Unit Price</th>
						<th>Active</th>
						<th>Edit</th>
					</tr>
				</thead>

				<tfoot>

				</tfoot>
			</table>
		</div>
	</div>
	</div>
	
	
	<script type="text/javascript">
	
	  
	
	</script>
</body>
</html>
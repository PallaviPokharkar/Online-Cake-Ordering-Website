<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

</head>
<body>


<div class="container">

<div class="row justify-content-center">
<div class="col-md-6">
<a href="orders.jsp" class=" btn btn-info">View Orders</a>
<a href="index.jsp" class=" btn btn-info">Logout</a>
<div class="card">
<header class="card-header">
<center><img src="img/log.jpeg" style="width:250px; height:auto;"></center>

	<h4 class="card-title mt-2">Add Product</h4>
</header>
<article class="card-body">
<form action='AddCake' enctype="multipart/form-data"  method='post' class="form">
			
			
			<div class="form-group">
				<label>Enter Cake Name</label>
				<input type="text" name="name" placeholder="Enter Name" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Enter Description</label>
				<input type="text" name="desc" placeholder="Enter Description" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Enter Price</label>
				<input type="text" name="price" placeholder="Enter Price" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Select File</label>
				<input type="file" name="image" placeholder="Select image" class="form-control"/>
			</div>
			
			<div class="form-group">
				<input type="submit" value="Add Cake" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
		</form>
</article>

</div>
</div> 

</div>


</div> 
<!--container end.//-->

</body>
</html>
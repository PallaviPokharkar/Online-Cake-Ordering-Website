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

<jsp:include page="header.jsp"></jsp:include>
<div class="container">

<div class="row justify-content-center">
<div class="col-md-6">
<div class="card mt-2">
<header class="card-header" style="background-color:#FADCD9;">
	
	<h4 class="card-title mt-2">Forget Password</h4>
</header>
<article class="card-body">
<form action="SendPassword" method="post">
	
	<div class="form-group">
		<label>Email address</label>
		<input type="email" name="email" class="form-control" placeholder="Enter email" required>
	</div> 
	 
	 
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block">Login </button>
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
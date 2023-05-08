<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/js/bootstrap.min.js" integrity="sha384-XEerZL0cuoUbHE4nZReLT7nx9gQrQreJekYhJD9WNWhH8nEW+0c5qq7aIo2Wl30J" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
		<style>
			
			nav,button{
			background-color: #FADCD9;
			}
			nav{
				height:"50";
			}
		</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light">
  <b><a class="navbar-brand" href="#"> <img src="img/log.jpeg" width="30" height="30" class="d-inline-block align-top" alt="">  The Food Lustre</a></b>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="navbar-brand" href="index.jsp"> Home </a>
      </li>
      <c:if test="${m==null}">
      <li class="nav-item">
        <a class="navbar-brand" href="login.jsp">Login</a>
      </li>
      <li class="nav-item">
        <a class="navbar-brand" href="register.jsp">Register</a>
      </li>
      </c:if>
     
      <c:if test="${m!=null}">
       <li class="nav-item">
        <a class="navbar-brand" href="yourOrdered.jsp">Your Ordered</a>
        
      </li>
      <li class="nav-item">
        <a class="navbar-brand" href="cart.jsp">Cart</a>
      </li>
      
      <li class="nav-item">
        <a class="navbar-brand" href="login.jsp">Logout</a>
      </li>
      
      </c:if>
      
    </ul>
    
    <form class="form-inline my-2 my-lg-0" action="index.jsp">
      <input class="form-control mr-sm-2" type="search" name="name" placeholder="Search" aria-label="Search" required>
      <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
</body>
</html>

  
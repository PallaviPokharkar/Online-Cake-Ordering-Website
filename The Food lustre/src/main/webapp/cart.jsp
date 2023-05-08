<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
		 <div class="container">
			
			<sql:setDataSource driver="com.mysql.jdbc.Driver"
							   url="jdbc:mysql://localhost:3306/butter"
							   user="root"
							   password="root"
							   var="con"/>
			
   	<sql:query var="rs" dataSource="${con}">
		select * from cart where status='Unordered' AND uid=?
		<sql:param>${m.uid}</sql:param>
	</sql:query>
	<div class="container">
	
	<c:if test="${empty rs.rows}">
		<h2 class="text-center">Sorry, No cart Available!!! please add product to cart</h2>
	</c:if>
	<c:if test="${not empty rs.rows}">
	
	<div class="row">	
	<c:forEach items="${rs.rows}" var="cart">
		<sql:query var="rs2" dataSource="${con}">
			select * from cakes where cake_id=?
			<sql:param>${cart.cake_id}</sql:param>
		</sql:query>
   		
			
					<c:forEach items="${rs2.rows}" var="row">
						<div class=m-2  >	
							<div class="card" style="width: 20rem; margin-top:10px; background-color: #FADCD9;">
								<center><img src="Image?id=${row.cake_id}" style="height:250px; width:auto;" class="card-img-top" alt="..."></center>
								<div class="card-body">
									<h5 class="card-title">${row.name}</h5>
									<p class="card-text">${row.description}</p>
								</div>
								<ul class="list-group list-group-flush">
									<li class="list-group-item">RS.${row.price*cart.qty}</li>
								</ul>
								
								<div class="card-body">
									<form action="UpdateCart">
									<input type="hidden" name="id" value="${cart.cart_id}">
									<div class="form-group">
								
									Qty : <input class="col-lg-3" type="number" name="qty" min="1" max="5" value="${cart.qty}"/><input type="submit" value="Update Quantity" class="btn btn-success ml-2"/>
									</div>
									</form>
									<div class="form-group">
									<a href="payment.jsp?id=${cart.cart_id}" class="btn btn-primary btn-block">Proceed To Buy</a>
									<a href="DeleteCartItem?id=${cart.cart_id}" class="btn btn-danger btn-block">Remove from Cart</a>
									
									</div>
									
								</div>
							</div>
						</div>
					</c:forEach>
					</c:forEach>
				</div>
				</c:if>
				</div>
				
				
			</div>
		
</body>
</html>
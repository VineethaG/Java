
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.model.*" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE HTML>
<html>
<head>
<meta>
<title>eCommerce Application</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/annyang/2.6.0/annyang.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.8.10/themes/smoothness/jquery-ui.css"
	type="text/css">
<script type="text/javascript"
	src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<style>
* {
	box-sizing: border-box;
}

/* Add padding to containers */
.container {
	padding: 16px;
	background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

/* Set a style for the submit button */
.registerbtn {
	background-color: #3b5998;
	color: white;
	padding: 10px 10px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

{
box-sizing:border-box;
}
.column {
	float: left;
	width: 33.33%;
	padding: 5px;
}

/* Clearfix (clear floats) */
.row::after {
	content: "";
	clear: both;
	display: table;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	width: auto;
}

div.figure {
  width: 40%;
  text-align: center;
  font-style: italic;
  font-size: smaller;
  text-indent: 0;
  border: thin silver solid;
  margin: 0.5em;
  padding: 0.5em;
}
.crop {
 height: 200px;
 width: 300px;
 overflow: hidden;
}
.crop img {
 height: auto;
 width: 200px;
}

</style>
</head>

<body>
	<script>


		
		
		//Add to Cart
		function addToCart(id,action) {
			console.log(id);
			$.ajax({
				type : "post",
				url : "cartServlet",
				data : {
					id : id,
					action: action
				},
				success : function(data) {
		            window.location.href = "cart.jsp";
				}
			});
		}
	</script>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Shopping App!</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#home" data-toggle="pill">Home</a></li>
			</ul>			
			<ul class="nav navbar-nav navbar-right">
			<li><a href="#viewcart" data-toggle="pill">			
			<img src="${pageContext.request.contextPath }/images/c48.png" width="90%"> 
			</a></li>
			<li><a href="#viewwish" data-toggle="pill">			
			<img src="${pageContext.request.contextPath }/images/ww.png" width="110%"> 
			</a></li>

			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<a href="cart.jsp">Show Cart List</a><br>
			<a href="wish.jsp">Show Wish List</a><br>
				<div class="row">
					<c:forEach var="product" items="${productlist}">
						<div class="column figure">
						<div class="crop" id ="image"><img src="${product.url }"></div>
						<p align="left" id ="productname"><b>Name: </b><c:out value="${product.name}" /></p>
						<p align="left" id="productDesc"><b>Description:</b> <c:out value="${product.desc}" /></p>
						<p align="left" id="price"><b>Price: $</b><c:out value="${product.price}" /></p>
						<a href="#" onclick="javascript:addToCart(${product.id},'fromProductList');">
						<button type="button" class="registerbtn" value = "Add to Cart">
						Add to Cart</button></a>
						</div>
					</c:forEach>
				</div>
			</div>

			<div id="viewcart" class="tab-pane fade">
			<div class="row">
				<c:forEach var="cart" items="${cartlist}">
				<div class="column figure">
						<div class="crop" id ="image"><img src="${cart.url }"></div>
						<p align="left" id ="productname"><b>Name: </b><c:out value="${cart.name}" /></p>
						<p align="left" id="productDesc"><b>Description:</b> <c:out value="${cart.desc}" /></p>
						<p align="left" id="price"><b>Price: $</b><c:out value="${cart.price}" /></p>
						<a href="#" onclick="javascript:addToWish(${cart.id});">
						<button type="button" class="registerbtn" value = "Add to wish">
						Add to Wish list</button></a>
						</div>
				</c:forEach>
			</div>
			</div>
			
			<div id="viewwish" class="tab-pane fade">
			<div class="row">
				<c:forEach var="wish" items="${wishlist}">
				<div class="column figure">
						<div class="crop" id ="image"><img src="${wish.url }"></div>
						<p align="left" id ="productname"><b>Name: </b><c:out value="${wish.name}" /></p>
						<p align="left" id="productDesc"><b>Description:</b> <c:out value="${wish.desc}" /></p>
						<p align="left" id="price"><b>Price: $</b><c:out value="${wish.price}" /></p>
						<a href="#" onclick="javascript:addToCart(${wish.id},'fromWishList');">
						<button type="button" class="registerbtn" value = "Add to wish">
						Add to Cart</button></a>
						</div>
				</c:forEach>
			</div>
			</div>
		
			

		</div>
	</div>
</body>
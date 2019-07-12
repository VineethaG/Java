
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		// Checking for Password Flag
		var isValidPassword = false;
		var check = function() {
			if ($("#regPassword").val() != "" || $("#regConfirmPassword").val()) {
				if ($("#regPassword").val() == $("#regConfirmPassword").val()) {
					$("#passwordMsg").css("color", "green");
					$("#passwordMsg").html('Passwords Matched');
					isValidPassword = true;
				} else {
					$("#passwordMsg").css("color", "red");
					$("#passwordMsg").html('Passwords Not Matching');
					isValidPassword = false;
				}
			} else {
				$("#passwordMsg").css("color", "");
				$("#passwordMsg").html('');
			}
		}

		function registerUser() {
			if (!isValidPassword) {
				// Throw Passwords Mismatch
				alert("Passwords Mismatch -- Please enter valid passwords");
			} else {
				// Insert the User
				$.ajax({
					type : "post",
					url : "UserRegisterServlet",
					data : {
						userPhone : $('#registerPhone').val(),
						password : $('#regPassword').val(),
						userName : $("#regusername").val(),
					},
					success : function(msg) {
						if (msg.status == 400 || msg.status == 500) {
							// User already exists or Server error
							alert(msg.entity);
						} else if (msg.status == 200) {
							// Navigate to Student/ Professor page
							$("#registerForm").attr("action",
									"/Idbms-Project/redirectPage").submit();
						}
					}
				});
			}
		}

		// Login
		function loginUser() {
			$.ajax({
				type : "post",
				url : "/Idbms-Project/loginUser",
				contentType : "application/json",
				data : JSON.stringify({
					userId : $('#loginuserid').val(),
					password : $('#loginpassword').val()
				}),
				success : function(msg) {
					if (msg.status == 400 || msg.status == 500) {
						// User already exists or Server error
						alert(msg.entity);
					} else if (msg.status == 200) {
						// Navigate to Student/ Professor page
						$("#loginForm").attr("action",
								"/Idbms-Project/redirectPage").submit();
					}
				}
			});
		}
		
		//Add to Cartojk
		function addToCart(productid) {
			console.log(productid);
			$.ajax({
				type : "post",
				url : "cartServlet",
				data : {
					product_id : productid
				},
				success : function(msg) {
					if (msg.status == 400 || msg.status == 500) {
						// User already exists or Server error
						alert(msg.entity);
					} else if (msg.status == 200) {
						// Navigate to Student/ Professor page
						$("#loginForm").attr("action",
								"/redirectPage").submit();
					}
				}
			});
		}
		
		function viewCart() {
			$.ajax({
				type : "get",
				url : "viewCart",			
				success : function(msg) {
					if (msg.status == 400 || msg.status == 500) {
						alert(msg.entity);
					} else if (msg.status == 200) {
						$("#loginForm").attr("action",
								"/redirectPage").submit();
					}
				}
			});
		}
	</script>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Shopping APP!</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#home" data-toggle="pill">Home</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
			<li><a href="#viewCart">			
			<img src="${pageContext.request.contextPath }/images/c48.png" width="90%"> 
			</a></li>
			<li><a href="javascript:viewWish();">			
			<img src="${pageContext.request.contextPath }/images/ww.png" width="110%"> 
			</a></li>

				<li><a href="#signup" data-toggle="pill"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="#login" data-toggle="pill"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<div class="row">
					<c:forEach var="product" items="${productlist}">
						<div class="column figure">
						<div class="crop" id ="image"><img src="${product.url }"></div>
						<p align="left" id ="productname"><b>Name: </b><c:out value="${product.name}" /></p>
						<p align="left" id="productDesc"><b>Description:</b> <c:out value="${product.desc}" /></p>
						<p align="left" id="price"><b>Price: $</b><c:out value="${product.price}" /></p>
						<a href="#" onclick="javascript:addToCart(${product.id});">
						<button type="button" class="registerbtn" value = "Add to Cart">
						Add to Cart</button></a>
						</div>
					</c:forEach>
				</div>
			</div>

			<div id="viewCart" class="tab-pane fade">
			<div class="row">
				<c:forEach var="cart" items="${cartlist}">
				<div class="column figure">
						<div class="crop" id ="image"><img src="${cart.url }"></div>
						<p align="left" id ="productname"><b>Name: </b><c:out value="${cart.name}" /></p>
						<p align="left" id="productDesc"><b>Description:</b> <c:out value="${cart.desc}" /></p>
						<p align="left" id="price"><b>Price: $</b><c:out value="${cart.price}" /></p>
						<a href="#" onclick="javascript:addToWish(${cart.id});">
						<button type="button" class="registerbtn" value = "Add to Cart">
						Add to Wish list</button></a>
						</div>
				</c:forEach>
			</div>
			<div id="viewWIshlist" class="tab-pane fade"></div>
			
			<div id="signup" class="tab-pane fade">
				<form id="registerForm" action="javascript:registerUser();"
					method="post">
					<div class="container">
						<h1 align="center">Register</h1>
						<label for="userPhone"><b>Phone Number:</b></label> <input
							type="text" placeholder="Enter User Phone Number"
							id="registerPhone" maxLength="9" name="reguserid" required>
						<label for="userName"><b>User Name:</b></label> <input type="text"
							placeholder="Enter UserName" id="regusername" maxLength="30"
							name="regusername" required> <label for="psw"><b>Password</b></label>
						<input type="password" placeholder="Enter Password" maxLength="20"
							name="regPassword" id="regPassword" onkeyup="check()" required>
						<label for="psw-repeat"><b>Repeat Password</b></label> <input
							type="password" placeholder="Repeat Password" maxLength="20"
							name="regConfirmPassword" required onkeyup="check()"
							id="regConfirmPassword">

						<p id="passwordMsg"></p>

						<button type="submit" class="registerbtn">Register</button>
					</div>

					<div class="container signin">
						<p>
							Already have an account? <a href="#login">Sign in</a>.
						</p>
					</div>
				</form>
			</div>
			<div id="login" class="tab-pane fade">
				<form id="loginForm" action="javascript:loginUser();" method="post">
					<div class="container">
						<h1 align="center">Login</h1>

						<label for="userID"><b>User ID:</b></label> <input type="text"
							placeholder="Enter User ID" name="loginuserid" id="loginuserid"
							required> <label for="password"><b>Password:</b></label><input
							type="password" placeholder="Enter Password" id="loginpassword"
							name="loginpassword" required>

						<button type="submit" class="registerbtn">Login</button>
					</div>

				</form>
			</div>

		</div>
	</div>
</body>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<style>
		.error {color:red}
   </style>

</head>
<body>
<i>Fill out the form (* means required)</i><br><br>
	<form:form action="processForm" modelAttribute="student">
	First Name:<form:input type="text" path="firstName" />
		<br><br>
	Last Name(*)<form:input type="text" path="lastName" />
		<form:errors path="lastName" cssClass="error"/>
	
		<br><br>
	Country: <form:select path="country" >
				<form:options items="${student.countryOptions}"/>
			</form:select>
	<br><br>
	Used Operating Systems: 
	<form:checkboxes path="operatingSystems" items="${student.OSOptions}"/>
		<br><br>
	Favorite Language:  
		Java<form:radiobutton path="favLanguage" value="JAVA"/> 
		Python<form:radiobutton path="favLanguage" value="Python"/> 
		PHP<form:radiobutton path="favLanguage" value="PHP"/> 
		<br><br>
	<input type="submit" value="submit"/>

	</form:form>
</body>
</html>
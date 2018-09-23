<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   



    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>home page</title>
	 
	</head>
<body>
<h1>New Ninja</h1>
<form:form action="/ninja/new" method="post">
    <p>
        <select name="dojo">
			<option selected="selected">Select Dojo</option>
			<c:forEach items="${dojo}" var="dojo">
				<option value="${dojo.id}">${dojo.name} </option>
			</c:forEach>
		</select>
    </p>
     
   		<label for="firstName">First Name:</label>
		<input type="text" name="firstName">
		<label for="lastName">Last Name</label>
		<input type="text" name="lastName">
		<label for="age">Age</label>
		<input type="text" name="age">
		
    <input type="submit" value="Submit"/>
</form:form>   
</body>
</html> 
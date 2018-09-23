 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>home page</title>
	 
	</head>
<body>
	<h1>All Dojo Locations</h1>
<table>
    <thead>
        <tr>
            <th>Dojo Location</th>
            <th>Number of Students</th>
            <th>Action</th>
            
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${dojo}" var="dojo" >
        <tr>
            <td><c:out value="${dojo.name}"/></td>
            <td><c:out value="${dojo.ninjas.size()}"/></td>
            <td> <a href="/dojo/${dojo.id}">Show</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/dojo/new">New Dojo Location</a>
<a href="/ninja/new">Add Contact</a>

	
</body>
</html>

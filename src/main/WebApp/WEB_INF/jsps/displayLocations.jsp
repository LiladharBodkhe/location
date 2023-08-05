<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored ="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Locations:</h2>
	
		<table border="1" cellpadding="5">
			<div align="center">
			<tr>
				<th>Id</th>
				<th>Code</th>
				<th>Name</th>
				<th>Type</th>
				<th colspan=2>Operation</th>
			</tr>
			<c:forEach var="location" items="${locations}">
				<tr>
					<td><c:out value="${location.id}" /></td>
					<td><c:out value="${location.code}" /></td>
					<td><c:out value="${location.name}" /></td>
					<td><c:out value="${location.type}" /></td>
					<td><a href="showupdate?id=${location.id}">Edit</a>
					<td><a href="deletelocation?id=${location.id}">Delete</a>
				</tr>


			</c:forEach>
</div>
		</table>
	
	<a href="showcreate" >Add Location</a>
	

</body>
</html>
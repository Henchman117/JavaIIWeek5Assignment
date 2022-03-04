<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Key Switch List</title>
</head>
<body>
	<form method = "post" action="navigationServlet">
	
	<table>

		<c:forEach items="${requestScope.allkeys}" var="currentitem">
		<tr>
			<td><input type="radio" name="id" value="${currentitem.id}"></td>
			<td>${currentitem.color}</td>
			<td>${currentitem.operatingForce}</td>
			<td>${currentitem.tactile}</td>
		</tr>
		</c:forEach>
		
	</table>
	
		<input type = "submit" value = "edit" name = "doThisToKey">
		<input type = "submit" value = "delete" name = "doThisToKey">
		<input type = "submit" value = "add" name = "doThisToKey">
	</form>

</body>
</html>
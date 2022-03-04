<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Key Lists</title>
</head>
<body>
	<form method = "post" action = "listNavigationServlet">
	<table>
		<c:forEach var="ListDetails" items="${requestScope.alllists}" >
		<tr>
			<td><input type="radio" name="id" value="${ListDetails.id}"></td>
			<td><h2>${ListDetails.listName}</h2></td></tr>
			<tr><td colspan="3">Creator: ${ListDetails.creator.creatorName}</td></tr>
				<c:forEach var = "KeySwitch" items = "${ListDetails.listOfKeys}">
					<tr><td></td><td colspan="3">${KeySwitch.color},${KeySwitch.operatingForce},${KeySwitch.tactile}</td></tr>
				</c:forEach>
		</c:forEach>
	</table>
	<input type = "submit" value = "delete" name="doThisToList">
	<input type="submit" value = "add" name = "doThisToList">
	</form>
	<a href="addKeysForListServlet">Create a new List</a>
	<a href="index.html">Insert a new item</a>
</body>
</html>
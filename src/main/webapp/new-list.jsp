<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>

	<form action = "createNewListServlet" method="post">
	List Name: <input type ="text" name = "listName"><br />
	Creator Name: <input type = "text" name = "creatorName"><br />
	
	Keys:<br />
	<select name="allKeysToAdd" multiple size="6">
	<c:forEach items="${requestScope.allkeys}" var="KeySwitch">
		<option value = "${KeySwitch.id}">${KeySwitch.color} | ${KeySwitch.operatingForce} | ${KeySwitch.tactile}</option>
	</c:forEach>
	</select>
	<br />
	<input type = "submit" value="Create List and Add Keys">
	</form>
	<a href = "index.html">Go add new items instead.</a>
</body>
</html>
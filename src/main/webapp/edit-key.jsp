<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action = "editKeyServlet" method="post">
	Color: <input type = "text" name = "color" value = "${keyToEdit.color}">
	Operating Force: <input type = "text" name = "operatingForce" value = "${keyToEdit.operatingForce}">
	Tactile: <input type = "text" name = "tactile" value = "${keyToEdit.tactile}">
	<input type = "hidden" name = "id" value = "${keyToEdit.id}">
	<input type = "submit" value = "Save Edited Item">
	</form>

</body>
</html>
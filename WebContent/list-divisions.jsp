<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Division List</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

	<h1>List of Divisions</h1>
	<a href="index.jsp">back home</a>
		<form action="StationControllerServlet" method="GET">
		<input type="submit" name="command" value="STATIONS" />
		<input type="submit" name="command" value="DIVISIONS" />
	</form>
	<table>
		<tr>
			<th>Division</th>
		</tr>
		<c:forEach var="tempStation" items="${DIVISION_LIST}">
		<c:url var="divisionLink" value="StationControllerServlet">
			<c:param name="command" value="ONEDIVISION" />
			<c:param name="divisionName" value="${tempStation.division }" />
		</c:url>
			<tr>
				<td><a href="${divisionLink}">${tempStation.division}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
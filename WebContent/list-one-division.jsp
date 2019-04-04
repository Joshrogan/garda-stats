<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Station List</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

	<h1>List of stations</h1>
	<a href="index.jsp">back home</a>
		<form action="StationControllerServlet" method="GET">
		<input type="submit" name="command" value="STATIONS" />
		<input type="submit" name="command" value="DIVISIONS" />
	</form>
	<table>
		<tr>
			<th>Station</th>
			<th>Division</th>
			<th>Murders/Assaults</th>

		</tr>
		<c:forEach var="tempStation" items="${THE_DIVISION}">
			<tr>
				<td>${tempStation.stationName}</td>
				<td>${tempStation.division}</td>
				<td>${tempStation.murderAssault}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>
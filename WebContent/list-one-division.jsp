<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Station List</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

	<nav class="navbar navbar-light bg-light">
	  <a class="navbar-brand" href="#">
	    <i class="fas fa-balance-scale"></i>
	    Garda Stats
	  </a>
	</nav>
	
	<h1>Single Division Statistics: </h1>
	<form action="StationControllerServlet" method="GET">
		<input class="btn btn-primary btn-lg" type="submit" name="command" value="STATIONS" />
		<input class="btn btn-warning btn-lg" type="submit" name="command" value="DIVISIONS" />
		<input class="btn btn-danger btn-lg" type="button" onclick="location.href='worst-of.jsp';" value="WORST OF" />
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
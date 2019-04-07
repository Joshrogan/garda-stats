<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Worst of X</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<!-- storing value of dropdown selected -->
<c:set var="dropdown" value="${searchTerm}" />
	<nav class="navbar navbar-light bg-light">
	  <a class="navbar-brand" href="index.jsp">
	    <i class="fas fa-balance-scale"></i>
	    Garda Stats
	  </a>
	</nav>

	<h1>Worst Offending Stations by Category: </h1>
	<form action="StationControllerServlet" method="GET">
		<input class="btn btn-primary btn-lg" type="submit" name="command" value="STATIONS" />
		<input class="btn btn-warning btn-lg" type="submit" name="command" value="DIVISIONS" />
		<input class="btn btn-danger btn-lg" type="button" onclick="location.href='worst-of.jsp';" value="WORST OF" />
	</form>

	<table>
		<tr>
			<th>Station</th>
			<th>Division</th>
			<th> 
			<form action="StationControllerServlet" method="GET">
				<select name="worstTerm">
				  <option value="volvo" <c:if test = "${dropdown == 'volvo'}">selected </c:if>>Volvo</option>
				  <option value="murder" <c:if test = "${dropdown == 'murder'}">selected </c:if>>Murder/Assaults</option>
				  <option value="fiat" <c:if test = "${dropdown == 'fiat'}">selected </c:if>>Fiat</option>
				  <option value="audi" <c:if test = "${dropdown == 'audi'}">selected </c:if>>Audi</option>
				</select>
				<input type="submit" value="WORST" name="command"> 
			</form>
			</th>
		</tr>
		<c:forEach var="tempStation" items="${STATION_LIST}">
			<tr>
				<td>${tempStation.stationName}</td>
				<td>${tempStation.division}</td>
				<td>${tempStation.murderAssault}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
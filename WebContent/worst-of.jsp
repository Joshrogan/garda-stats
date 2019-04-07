<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Worst of X</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<c:set var="test1" value="${searchTerm}" />

<h1>ok: <c:out value="${test1}" /></h1>
	<table>
		<tr>
			<th>Station</th>
			<th>Division</th>
			<th> 
			<form action="StationControllerServlet" method="GET">
				<select name="worstTerm">
				  <option value="volvo" <c:if test = "${test1 == 'volvo'}">selected </c:if>>Volvo</option>
				  <option value="murder" <c:if test = "${test1 == 'murder'}">selected </c:if>>Murder/Assaults</option>
				  <option value="fiat" <c:if test = "${test1 == 'fiat'}">selected </c:if>>Fiat</option>
				  <option value="audi" <c:if test = "${test1 == 'audi'}">selected </c:if>>Audi</option>
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
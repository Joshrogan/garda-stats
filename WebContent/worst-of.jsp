<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Worst of X</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
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
				  <option value="attemptsthreatstomurderassaultsharassmentsandrelatedoffences"
				   	<c:if test = "${dropdown == 'attemptsthreatstomurderassaultsharassmentsandrelatedoffences'}">selected </c:if>>murder/Assault</option>
				  <option value="dangerousornegligentacts" <c:if test = "${dropdown == 'dangerousornegligentacts'}">selected </c:if>>Negligence</option>
				  <option value="kidnappingandrelatedoffences" <c:if test = "${dropdown == 'kidnappingandrelatedoffences'}">selected </c:if>>kidnapping</option>
				  <option value="robberyextortionandhijackingoffences" <c:if test = "${dropdown == 'robberyextortionandhijackingoffences'}">selected </c:if>>robbery/Extort/Hijack</option>
				  <option value="burglaryandrelatedoffences" <c:if test = "${dropdown == 'burglaryandrelatedoffences'}">selected </c:if>>burglary</option>
				  <option value="theftandrelatedoffences" <c:if test = "${dropdown == 'theftandrelatedoffences'}">selected </c:if>>theft</option>
				  <option value="frauddeceptionandrelatedoffences" <c:if test = "${dropdown == 'frauddeceptionandrelatedoffences'}">selected </c:if>>fraud</option>
				  <option value="controlleddrugoffences" <c:if test = "${dropdown == 'controlleddrugoffences'}">selected </c:if>>drugs</option>
				  <option value="weaponsand_explosives_offences" <c:if test = "${dropdown == 'weaponsand_explosives_offences'}">selected </c:if>>weapons</option>
				  <option value="damagetopropertyandtotheenvironment" <c:if test = "${dropdown == 'damagetopropertyandtotheenvironment'}">selected </c:if>>property</option>
				  <option value="publicorderandothersocialcodeoffences" <c:if test = "${dropdown == 'publicorderandothersocialcodeoffences'}">selected </c:if>>public order</option>
				  <option value="offencesagainstgovernmentjusticeproceduresandorgofcrime" 
				  	<c:if test = "${dropdown == 'offencesagainstgovernmentjusticeproceduresandorgofcrime'}">selected </c:if>>org crime</option>
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
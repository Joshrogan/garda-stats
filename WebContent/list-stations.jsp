<%@ page import="java.util.*, com.javadbproject.jdbc.*" %>
<!DOCTYPE html>
<html>
<head>
	<title>Station List</title>
</head>
<%
	List<Station> stations = (List<Station>) request.getAttribute("STATION_LIST");
%>
<body>

	<h1>List of stations</h1>
	<br/><br/>
	<table>
		<tr>
			<th>Station</th>
			<th>Division</th>
			<th>Murders/Assaults</th>
		</tr>
		<% for (Station tempStation : stations) { %>
			<tr>
				<td><%= tempStation.getStationName() %></td>
				<td><%= tempStation.getDivision() %></td>
				<td><%= tempStation.getMurderAssault() %></td>
			</tr>
		<% } %>
	</table>


</body>
</html>
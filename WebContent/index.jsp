<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Garda Stats Home Page</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

	<h1>Garda Stats Home Page</h1>
	<form action="StationControllerServlet" method="GET">
		<input type="submit" name="command" value="STATIONS" />
		<input type="submit" name="command" value="DIVISIONS" />
		<input type="button" onclick="location.href='worst-of.jsp';" value="Worst of" />
	</form>

</body>
</html>
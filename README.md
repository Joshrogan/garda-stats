# Garda Stats 2nd Year Java project

I Downloaded and turned a garda crime CSV statistics file (source: https://data.gov.ie) into a SQL database.
Then I used JDBC to connect to the MySQL database and Tomcat to render the Java Server Pages.

##Features
* Search box that searches all stations/divisions
* Browse by Divison to find the worst/best stations in an area
* Worst offending stations by category


## Also Built With

* [Apache Tomcat](http://tomcat.apache.org/) - an open-source Java Servlet Container to handle JSP, JSTL and HTTP logic
* [MySQL](https://www.mysql.com/) - used to store the database
* [HTML/CSS/Bootstrap](https://getbootstrap.com/) - To build the front end of the site

## Project Architecture

I tried to implement a Model-View-Controller Architecture in this project.

The MySQL database/Student class form the Model, the JSP pages are the View 
and the StationControllerServlet is the Controller because it 
requests information from the Model via the StationDbUtil object
and sends this information to the JSP pages.

## Files/Classes of note
Java Resources/src/com.javadbproject.jdbc/Station.java
Java Resources/src/com.javadbproject.jdbc/StationControllerServlet.java
Java Resources/src/com.javadbproject.jdbc/StationDbUtil.java

WebContent/index.jsp
WebContent/list-divisions.jsp
WebContent/list-one-division.jsp
WebContent/list-stations.jsp
WebContent/worst-of.jsp

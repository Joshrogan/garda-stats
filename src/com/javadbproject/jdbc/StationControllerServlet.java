/******************************
* Class name: StationControllerServlet.java
* Class Description:
* 
* Our StationControllerServlet takes in requests from 
* the jsp/html pages and uses a stationDbUtil object to 
* interact with the MySQL database and send the results
* back out to the jsp/html view.
* 
* All methods in this class follow a similar format:
* 
* 1. Get Stations/Divisions results from StationDbUtil object
* 2. pass it back to the appropriate jsp page with results attached.
* 
 ******************************/
package com.javadbproject.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/StationControllerServlet")
public class StationControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StationDbUtil stationDbUtil;
	
	//Found in META-INF/context.xml
	@Resource(name="jdbc/garda_stats")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			stationDbUtil = new StationDbUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			
			switch (command) {
				case "STATIONS":
					listStations(request, response);
					break;
					
				case "DIVISIONS":
					listDivisions(request, response);
					break;
					
				case "ONEDIVISION":
					listOneDivision(request, response);
					break;
				
				case "SEARCH":
					searchStations(request, response);
					break;
					
				case "WORST":
					worstStations(request, response);
					break;
					
				default:
					listStations(request, response);
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void listOneDivision(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String divisionName = request.getParameter("divisionName");
		
		List<Station> divisionList = stationDbUtil.getOneDivision(divisionName);
		
		request.setAttribute("THE_DIVISION", divisionList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-one-division.jsp");
		dispatcher.forward(request, response);
		
	}

	private void listStations(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Station> stations = stationDbUtil.getStations();
		
		request.setAttribute("STATION_LIST", stations);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-stations.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listDivisions(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Station> divisions = stationDbUtil.getDivisions();
		
		request.setAttribute("DIVISION_LIST", divisions);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-divisions.jsp");
		dispatcher.forward(request, response);
	}
	
    private void searchStations(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String searchTerm = request.getParameter("searchTerm");
        
        List<Station> stations = stationDbUtil.searchStations(searchTerm);
        
        request.setAttribute("STATION_LIST", stations);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-stations.jsp");
        dispatcher.forward(request, response);
    }
    
    private void worstStations(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String searchTerm = request.getParameter("worstTerm");
        
        List<Station> stations = stationDbUtil.worstStations(searchTerm);
        
        request.setAttribute("STATION_LIST", stations);
        request.setAttribute("searchTerm", searchTerm);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/worst-of.jsp");
        dispatcher.forward(request, response);
    }
}

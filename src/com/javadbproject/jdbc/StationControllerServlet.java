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
		listStations(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void listStations(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Station> stations = stationDbUtil.getStations();
		
		request.setAttribute("STATION_LIST", stations);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-stations.jsp");
		dispatcher.forward(request, response);
	}
}

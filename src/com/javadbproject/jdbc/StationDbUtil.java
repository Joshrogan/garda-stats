package com.javadbproject.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StationDbUtil {
	private DataSource dataSource;
	
	public StationDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Station> getStations() throws Exception {
		List<Station> stations = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		// try establish db connection, create/execute SQL, store in stations and close JDBC after
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from data order by divisions";
			
			statement = connection.createStatement();
			
			result = statement.executeQuery(sql);
			
			while(result.next()) {
				String stationName = result.getString("station");
				String division = result.getString("divisions");
				int murderAssault = 
						result.getInt("attemptsthreatstomurderassaultsharassmentsandrelatedoffences");
				
				Station tempStation = new Station(stationName, division, murderAssault);
				
				stations.add(tempStation);
			}
			
			return stations;
		} finally {
			close(connection, statement, result);
		}
	}

	private void close(Connection connection, Statement statement, ResultSet result) {
		try {
			if (result != null)
				result.close();
			
			if (statement != null)
				statement.close();
			
			if (connection != null)
				connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}

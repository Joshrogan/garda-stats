/******************************
* Class name: StationDbUtil.java
* Class Description:
* 
* Interaction with the MySQL database are handled in this class
* and passed back to the StationControllerServlet.
* 
* Prepared statements are used when user input into SQL queries is required,
* otherwise just regular statements used.
* 
* All methods follow similar format of try establish connection,
* create/execute query, close JDBC return results to StationControllerServlet
* 
 ******************************/
package com.javadbproject.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			
			String sql = "select * from data order by station";
			
			statement = connection.createStatement();
			
			result = statement.executeQuery(sql);
			
			while(result.next()) {
				String stationName = result.getString("station");
				String division = result.getString("divisions");
				int murderAssault = 
						result.getInt("attemptsthreatstomurderassaultsharassmentsandrelatedoffences");
				int dangerousNegligance = result.getInt("dangerousornegligentacts");
				int kidnapping = result.getInt("kidnappingandrelatedoffences");
				int robExtortHijack = result.getInt("robberyextortionandhijackingoffences");
				int burglary = result.getInt("burglaryandrelatedoffences");
				int theft = result.getInt("theftandrelatedoffences");
				int fraud = result.getInt("frauddeceptionandrelatedoffences");
				int drugs = result.getInt("controlleddrugoffences");
				int weapons = result.getInt("weaponsand_explosives_offences");
				int damageProperty = result.getInt("damagetopropertyandtotheenvironment");
				int publicOrder = result.getInt("publicorderandothersocialcodeoffences");
				int orgCrime = result.getInt("offencesagainstgovernmentjusticeproceduresandorgofcrime");
				
				Station tempStation = new Station(stationName, division, murderAssault, dangerousNegligance,
						kidnapping, robExtortHijack, burglary, theft, fraud, drugs, weapons, damageProperty, 
						publicOrder, orgCrime);
				
				stations.add(tempStation);
			}
			
			return stations;
		} finally {
			close(connection, statement, result);
		}
	}
	
	public List<Station> getDivisions() throws Exception {
		List<Station> uniqueDivisions = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		// try establish db connection, create/execute SQL, store in uniqueDivisions and close JDBC after
		try {
			connection = dataSource.getConnection();
			
			String sql = "select distinct divisions from data order by divisions";
			
			statement = connection.createStatement();
			
			result = statement.executeQuery(sql);
			
			while(result.next()) {
				String division = result.getString("divisions");
				
				Station tempStation = new Station(division);
				
				uniqueDivisions.add(tempStation);
			}
		
			return uniqueDivisions;
		} finally {
			close(connection, statement, result);
		}
	}
	
	public List<Station> getOneDivision(String divisionName) throws Exception {
		List<Station> stations = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		// try establish db connection, create/execute SQL, store in stations and close JDBC after
		try {
			connection = dataSource.getConnection();
			
			//prepared statements let us handle different inputs and not hardcode
			String sql = "select * from data where divisions=?";
			
			statement = connection.prepareStatement(sql);
			statement.setString(1, divisionName);
			
			result = statement.executeQuery();
			
			while(result.next()) {
				String stationName = result.getString("station");
				String division = result.getString("divisions");
				int murderAssault = 
						result.getInt("attemptsthreatstomurderassaultsharassmentsandrelatedoffences");
				int dangerousNegligance = result.getInt("dangerousornegligentacts");
				int kidnapping = result.getInt("kidnappingandrelatedoffences");
				int robExtortHijack = result.getInt("robberyextortionandhijackingoffences");
				int burglary = result.getInt("burglaryandrelatedoffences");
				int theft = result.getInt("theftandrelatedoffences");
				int fraud = result.getInt("frauddeceptionandrelatedoffences");
				int drugs = result.getInt("controlleddrugoffences");
				int weapons = result.getInt("weaponsand_explosives_offences");
				int damageProperty = result.getInt("damagetopropertyandtotheenvironment");
				int publicOrder = result.getInt("publicorderandothersocialcodeoffences");
				int orgCrime = result.getInt("offencesagainstgovernmentjusticeproceduresandorgofcrime");
				
				Station tempStation = new Station(stationName, division, murderAssault, dangerousNegligance,
						kidnapping, robExtortHijack, burglary, theft, fraud, drugs, weapons, damageProperty, 
						publicOrder, orgCrime);
				
				stations.add(tempStation);
			}
			
			return stations;
		} finally {
			close(connection, statement, result);
		}
	}
	
    public List<Station> searchStations(String searchTerm)  throws Exception {
        List<Station> stations = new ArrayList<>();
        
        Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
        
		// try establish db connection, create/execute SQL, store in stations and close JDBC after
        try {
            connection = dataSource.getConnection();

            if (searchTerm != null && searchTerm.trim().length() > 0) {
                String sql = "select * from data where lower(station) like ? or lower(divisions) like ?";
                statement = connection.prepareStatement(sql);
                
                String searchTermLike = "%" + searchTerm.toLowerCase() + "%";
                statement.setString(1, searchTermLike);
                statement.setString(2, searchTermLike);
                
            } else {
                String sql = "select * from data order by divisions";
                statement = connection.prepareStatement(sql);
            }

            result = statement.executeQuery();
            
            while (result.next()) {
            	String stationName = result.getString("station");
				String division = result.getString("divisions");
				int murderAssault = 
						result.getInt("attemptsthreatstomurderassaultsharassmentsandrelatedoffences");
				int dangerousNegligance = result.getInt("dangerousornegligentacts");
				int kidnapping = result.getInt("kidnappingandrelatedoffences");
				int robExtortHijack = result.getInt("robberyextortionandhijackingoffences");
				int burglary = result.getInt("burglaryandrelatedoffences");
				int theft = result.getInt("theftandrelatedoffences");
				int fraud = result.getInt("frauddeceptionandrelatedoffences");
				int drugs = result.getInt("controlleddrugoffences");
				int weapons = result.getInt("weaponsand_explosives_offences");
				int damageProperty = result.getInt("damagetopropertyandtotheenvironment");
				int publicOrder = result.getInt("publicorderandothersocialcodeoffences");
				int orgCrime = result.getInt("offencesagainstgovernmentjusticeproceduresandorgofcrime");
				
				Station tempStation = new Station(stationName, division, murderAssault, dangerousNegligance,
						kidnapping, robExtortHijack, burglary, theft, fraud, drugs, weapons, damageProperty, 
						publicOrder, orgCrime);
				
				stations.add(tempStation);          
            }
            
            return stations;
        }
        finally {
            close(connection, statement, result);
        }
    }
    
    public List<Station> worstStations(String worstTerm)  throws Exception {
        List<Station> stations = new ArrayList<>();
        
        Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		
		// try establish db connection, create/execute SQL, store in stations and close JDBC after
		try {
			
			connection = dataSource.getConnection();
			
			//prepared statements let us handle different inputs and not hardcode
			String sql = "select * from data order by " + worstTerm + " DESC";
			
			statement = connection.prepareStatement(sql);
			
			
			result = statement.executeQuery();
			
			while(result.next()) {
				String stationName = result.getString("station");
				String division = result.getString("divisions");
				int worstChoice = 
						result.getInt(worstTerm);
				
				Station tempStation = new Station(stationName, division, worstChoice);
				
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

package com.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.airline.model.Flight;

public class FlightDAO {
	 public List<Flight> getAvailableFlights(String origin,String destination){
	    	List<Flight> flights = new ArrayList<>();
		String query ="select * from flights where origin = ? and destination = ?";
		
		try(Connection con = DatabaseConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(query)) {
			
			stmt.setString(1,origin);
			stmt.setString(2, destination);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Flight flight = new Flight();
				flight.setFlightId(rs.getInt("flight_id"));
				flight.setAirline(rs.getString("airline"));
				flight.setOrigin(rs.getString("origin"));
				flight.setDestination(rs.getString("destination"));
				flight.setDepartureTime(rs.getString("departure_time"));
				flight.setArrivalTime(rs.getString("arrival_time"));
				flight.setAvailableSeats(rs.getInt("available_seats"));
				
				flights.add(flight);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	    	
	    	
	    	return flights;
	    }
}

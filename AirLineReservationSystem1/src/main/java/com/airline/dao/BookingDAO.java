package com.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.airline.model.Booking;

public class BookingDAO {
	public boolean bookFlight(Booking booking) {
		  String query = "insert into bookings(flight_id,customer_name,customer_email,seat_class,status) values (?,?,?,?,?)";
		  
		  try(Connection con = DatabaseConnection.getConnection();
				  PreparedStatement stmt = con.prepareStatement(query)) {
			  
			  stmt.setInt(1, booking.getFlightId());
			  stmt.setString(2, booking.getCustomerName());
			  stmt.setString(3, booking.getCustomerEmail());
			  stmt.setString(4, booking.getSeatClass());
			  stmt.setString(5, booking.getStatus());
			  
			  int rowsInserted = stmt.executeUpdate();
			  return rowsInserted >0;	  
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }
		  return false;
		  
	  }
}

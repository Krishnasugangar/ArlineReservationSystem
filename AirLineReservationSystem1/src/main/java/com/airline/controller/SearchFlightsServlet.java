package com.airline.controller;

import java.io.IOException;
import java.util.List;

import com.airline.dao.FlightDAO;
import com.airline.model.Flight;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/searchFlights")
public class SearchFlightsServlet extends HttpServlet {
	private FlightDAO flightDAO = new FlightDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String origin = request.getParameter("origin");
		String destination = request.getParameter("destination");
		
		List<Flight> flights = flightDAO.getAvailableFlights(origin,destination);
		
		 String json = new Gson().toJson(flights);
		response.setContentType("application/json");
		response.getWriter().write(json);
		
	}

	

}
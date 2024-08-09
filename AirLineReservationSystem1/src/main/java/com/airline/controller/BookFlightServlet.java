package com.airline.controller;

import java.io.IOException;

import com.airline.dao.BookingDAO;
import com.airline.model.Booking;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/bookFlight")
public class BookFlightServlet extends HttpServlet {
    private BookingDAO bookingDAO = new BookingDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Booking booking = new Gson().fromJson(request.getReader(), Booking.class);

        boolean success = bookingDAO.bookFlight(booking);

        response.setContentType("application/json");
        response.getWriter().write("{\"success\":" + success + "}");
    }
}
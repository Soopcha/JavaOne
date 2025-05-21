package com.zoo.servlets;


import com.zoo.model.Ticket;
import com.zoo.service.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class TicketActionServlet extends HttpServlet {
    private TicketService ticketService;

    @Override
    public void init() throws ServletException {
        this.ticketService = TicketService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        if ("delete".equals(action)) {
            ticketService.deleteTicket(id);
        } else {
            String visitorName = request.getParameter("visitorName");
            double price = Double.parseDouble(request.getParameter("price"));
            String purchaseDate = request.getParameter("purchaseDate");

            Ticket ticket = new Ticket(id, visitorName, price, purchaseDate);

            if (id == 0) {
                ticketService.createTicket(ticket);
            } else {
                ticketService.updateTicket(ticket);
            }
        }

        response.sendRedirect("tickets");
    }
}

package com.zoo.servlets;


import com.zoo.model.Ticket;
import com.zoo.service.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TicketServlet extends HttpServlet {
    private TicketService ticketService;

    @Override
    public void init() throws ServletException {
        this.ticketService = TicketService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<Ticket> tickets = ticketService.getAllTickets();
        request.setAttribute("tickets", tickets);
        request.getRequestDispatcher("/tickets.jsp").forward(request, response);
    }
}

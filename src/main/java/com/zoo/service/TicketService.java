package com.zoo.service;

import com.zoo.dao.TicketDAO;
import com.zoo.model.Ticket;
import java.util.List;

public class TicketService {
    private static TicketService instance;
    private final TicketDAO ticketDAO;

    private TicketService() {
        this.ticketDAO = TicketDAO.getInstance();
    }

    public static synchronized TicketService getInstance() {
        if (instance == null) {
            instance = new TicketService();
        }
        return instance;
    }

    public List<Ticket> getAllTickets() {
        return ticketDAO.getAllTickets();
    }

    public Ticket getTicketById(int id) {
        return ticketDAO.getTicketById(id);
    }

    public void createTicket(Ticket ticket) {
        ticketDAO.insertTicket(ticket);
    }

    public void updateTicket(Ticket ticket) {
        ticketDAO.updateTicket(ticket);
    }

    public void deleteTicket(int id) {
        ticketDAO.deleteTicket(id);
    }
}
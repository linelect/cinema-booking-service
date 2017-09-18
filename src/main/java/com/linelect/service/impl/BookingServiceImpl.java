package com.linelect.service.impl;

import com.linelect.dao.EventDAO;
import com.linelect.dao.TicketDAO;
import com.linelect.model.*;
import com.linelect.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private TicketDAO ticketDAO;

    @Override
    public double getTicketsPrice(Event event, User user) {

        long ticketCount = ticketDAO.getTicketsByUser(user).stream()
                .filter(ticket -> ticket.getEvent().equals(event))
                .count();

        return event.getPrice() * ticketCount;
    }

    @Override
    public double getTicketsPrice(Event event) {
        int ticketsCount = ticketDAO.getTicketsByEvent(event).size();
        return event.getPrice() * ticketsCount;
    }

    @Override
    public Ticket bookTicket(User user, Event event, int numberOfSeat, int row, SeatType seatType) {
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setEvent(event);
        ticket.setAuditoriumSeat(new AuditoriumSeat(event.getAuditorium(), numberOfSeat, row, seatType));

        ticketDAO.add(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> getPurchasedTicketsForEvent(Event event) {
        return ticketDAO.getTicketsByEvent(event).stream()
                .filter(Ticket::isPayed)
                .collect(Collectors.toList());
    }
}

package com.linelect.dao.impl;

import com.linelect.dao.InMemoryDataBaseSimulator;
import com.linelect.dao.TicketDAO;
import com.linelect.model.Event;
import com.linelect.model.Ticket;
import com.linelect.model.User;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketDAOImpl implements TicketDAO {
    private int id = 1;

    @Override
    public Ticket save(Ticket ticket) {
        if (ticket.isNew()) {
            add(ticket);
        } else {
            delete(ticket.getId());
            add(ticket);
        }
        return ticket;
    }

    @Override
    public Ticket add(Ticket ticket) {
        ticket.setId(id++);
        InMemoryDataBaseSimulator.getTickets().add(ticket);
        return ticket;
    }

    @Override
    public void delete(int id) {
        InMemoryDataBaseSimulator.getTickets().remove(getById(id));
    }

    @Override
    public Ticket getById(int id) {
        return InMemoryDataBaseSimulator.getTickets().stream()
                .filter(ticket -> ticket.getId() == id)
                .findFirst().orElse(new Ticket());
    }

    @Override
    public List<Ticket> getAll() {
        return InMemoryDataBaseSimulator.getTickets();
    }

    @Override
    public List<Ticket> getTicketsByEvent(Event event) {
        return InMemoryDataBaseSimulator.getTickets().stream()
                .filter(ticket -> ticket.getEvent().equals(event))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getTicketsByUser(User user) {
        return InMemoryDataBaseSimulator.getTickets().stream()
                .filter(ticket -> ticket.getUser().equals(user))
                .collect(Collectors.toList());
    }
}

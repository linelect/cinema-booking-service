package com.linelect.dao;

import com.linelect.model.Event;
import com.linelect.model.Ticket;
import com.linelect.model.User;

import java.util.List;

public interface TicketDAO {
    Ticket save(Ticket ticket);

    Ticket add(Ticket ticket);

    void delete(int id);

    Ticket getById(int id);

    List<Ticket> getAll();

    List<Ticket> getTicketsByEvent(Event event);

    List<Ticket> getTicketsByUser(User user);
}

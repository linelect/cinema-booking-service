package com.linelect.service.impl;

import com.linelect.model.Event;
import com.linelect.model.Ticket;
import com.linelect.dao.EventDAO;
import com.linelect.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDAO eventDAO;


    @Override
    public Event save(Event event) {
        return eventDAO.save(event);
    }

    @Override
    public Event add(Event event) {
        return eventDAO.add(event);
    }

    @Override
    public void remove(int id) {
        eventDAO.delete(id);
    }

    @Override
    public Event getById(int id) {
        return eventDAO.getById(id);
    }

    @Override
    public Event getByName(String name) {
        return eventDAO.getByName(name);
    }

    @Override
    public List<Event> getAll() {
        return eventDAO.getAll();
    }

    @Override
    public List<Event> getForDateTimeRange(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        return eventDAO.getForDateTimeRange(fromDateTime, toDateTime);
    }

    @Override
    public List<Event> getNextEvents(LocalDateTime dateTime) {
        return eventDAO.getNextEvents(dateTime);
    }
}

package com.linelect.dao.impl;

import com.linelect.dao.EventDAO;
import com.linelect.dao.InMemoryDataBaseSimulator;
import com.linelect.model.Event;
import com.linelect.model.Ticket;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventDAOImpl implements EventDAO {
    private int id = 1;

    @Override
    public Event save(Event event) {
        if (event.isNew()) {
            add(event);
        } else {
            delete(event.getId());
            add(event);
        }
        return event;
    }

    @Override
    public Event add(Event event) {
        event.setId(id++);
        InMemoryDataBaseSimulator.getEvents().add(event);
        return event;
    }

    @Override
    public void delete(int id) {
        InMemoryDataBaseSimulator.getEvents().remove(getById(id));
    }

    @Override
    public Event getById(int id) {
        return InMemoryDataBaseSimulator.getEvents().stream()
                .filter(event -> event.getId() == id)
                .findFirst().orElse(new Event());
    }

    @Override
    public List<Event> getAll() {
        return InMemoryDataBaseSimulator.getEvents();
    }

    @Override
    public Event getByName(String name) {
        return InMemoryDataBaseSimulator.getEvents().stream()
                .filter(event -> event.getName().equals(name))
                .findFirst().orElse(new Event());
    }

    @Override
    public List<Event> getForDateTimeRange(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        return getAll().stream()
                .filter(event -> event.getDateTime().isAfter(fromDateTime) && event.getDateTime().isBefore(toDateTime))
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> getNextEvents(LocalDateTime dateTime) {
        return getAll().stream()
                .filter(event -> event.getDateTime().isAfter(dateTime))
                .collect(Collectors.toList());
    }
}

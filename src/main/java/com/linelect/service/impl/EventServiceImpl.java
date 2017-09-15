package com.linelect.service.impl;

import com.linelect.model.Event;
import com.linelect.repository.EventRepository;
import com.linelect.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        return eventRepository.saveAndFlush(event);
    }

    @Override
    public void remove(int id) {
        eventRepository.delete(id);
    }

    @Override
    public Event getById(int id) {
        return eventRepository.findOne(id);
    }

    @Override
    public Event getByName(String name) {
        return null;
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getForDateTimeRange(LocalDateTime fromDateTime, LocalDateTime DateTime) {
        return null;
    }

    @Override
    public List<Event> getNextEvents(LocalDateTime dateTime) {
        return null;
    }
}

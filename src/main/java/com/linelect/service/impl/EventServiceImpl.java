package com.linelect.service.impl;

import com.linelect.model.Event;
import com.linelect.service.EventService;

import java.time.LocalDateTime;
import java.util.List;

public class EventServiceImpl implements EventService {
    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public Event getById() {
        return null;
    }

    @Override
    public Event getByName() {
        return null;
    }

    @Override
    public List<Event> getAll() {
        return null;
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

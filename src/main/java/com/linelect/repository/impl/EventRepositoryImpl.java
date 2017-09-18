package com.linelect.repository.impl;

import com.linelect.model.Event;
import com.linelect.repository.EventRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventRepositoryImpl implements EventRepository {
    @Override
    public Event saveAndFlush(Event event) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Event findOne(int id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        return null;
    }
}

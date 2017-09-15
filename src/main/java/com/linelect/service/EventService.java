package com.linelect.service;

import com.linelect.model.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
    Event save(Event event);

    void remove(int id);

    Event getById(int id);

    Event getByName(String name);

    List<Event> getAll();

    List<Event> getForDateTimeRange(LocalDateTime fromDateTime, LocalDateTime DateTime);

    List<Event> getNextEvents(LocalDateTime dateTime);
}

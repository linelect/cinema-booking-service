package com.linelect.service;

import com.linelect.model.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
    boolean save();

    boolean remove();

    Event getById();

    Event getByName();

    List<Event> getAll();

    List<Event> getForDateTimeRange(LocalDateTime fromDateTime, LocalDateTime DateTime);

    List<Event> getNextEvents(LocalDateTime dateTime);
}

package com.linelect.repository;

import com.linelect.model.Event;

import java.util.List;

public interface EventRepository  {
    Event saveAndFlush(Event event);

    void delete(int id);

    Event findOne(int id);

    List<Event> findAll();

}

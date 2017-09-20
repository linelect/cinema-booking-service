package com.linelect.service;

import com.linelect.model.Auditorium;

import java.util.List;

public interface AuditoriumService {
    Auditorium add(Auditorium auditorium);

    List<Auditorium> getAll();

    Auditorium getById(int id);

    int getNumberOfSeats(int id);
}

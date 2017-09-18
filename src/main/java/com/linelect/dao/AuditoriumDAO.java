package com.linelect.dao;

import com.linelect.model.Auditorium;

import java.util.List;

public interface AuditoriumDAO {
    List<Auditorium> getAll();

    Auditorium getById(int id);

    Auditorium add(Auditorium auditorium);

    Auditorium save(Auditorium auditorium);

    void delete(int id);
}

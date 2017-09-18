package com.linelect.repository;

import com.linelect.model.Auditorium;

import java.util.List;

public interface AuditoriumRepository {
    List<Auditorium> findAll();

    Auditorium findOne(int id);
}

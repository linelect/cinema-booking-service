package com.linelect.repository.impl;

import com.linelect.model.Auditorium;
import com.linelect.repository.AuditoriumRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuditoriumRepositoryImpl implements AuditoriumRepository {
    @Override
    public List<Auditorium> findAll() {
        return null;
    }

    @Override
    public Auditorium findOne(int id) {
        return null;
    }
}

package com.linelect.service.impl;

import com.linelect.model.Auditorium;
import com.linelect.repository.AuditoriumRepository;
import com.linelect.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Override
    public List<Auditorium> getAll() {
        return auditoriumRepository.findAll();
    }

    @Override
    public Auditorium getById(int id) {
        return auditoriumRepository.findOne(id);
    }

    @Override
    public int getNumberOfSeats(int id) {
        return 0;
    }
}

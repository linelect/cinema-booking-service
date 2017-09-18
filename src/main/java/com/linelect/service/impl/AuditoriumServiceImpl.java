package com.linelect.service.impl;

import com.linelect.model.Auditorium;
import com.linelect.dao.AuditoriumDAO;
import com.linelect.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    @Autowired
    private AuditoriumDAO auditoriumDAO;


    @Override
    public List<Auditorium> getAll() {
        return auditoriumDAO.getAll();
    }

    @Override
    public Auditorium getById(int id) {
        return auditoriumDAO.getById(id);
    }

    @Override
    public int getNumberOfSeats(int id) {
        return auditoriumDAO.getById(id).getNumberOfSeats();
    }
}

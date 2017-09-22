package com.linelect.dao.impl.inmemory;

import com.linelect.dao.AuditoriumDAO;
import com.linelect.InMemoryDataBaseSimulator;
import com.linelect.model.Auditorium;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuditoriumDAOImpl implements AuditoriumDAO {

    private int id = 1;

    @Override
    public List<Auditorium> getAll() {
        return InMemoryDataBaseSimulator.getAuditoriums();
    }

    @Override
    public Auditorium getById(int id) {
        return InMemoryDataBaseSimulator.getAuditoriums().stream()
                .filter(auditorium -> auditorium.getId() == id)
                .findFirst().orElse(new Auditorium());

    }

    @Override
    public Auditorium add(Auditorium auditorium) {
        auditorium.setId(id++);
        InMemoryDataBaseSimulator.getAuditoriums().add(auditorium);
        return auditorium;
    }

    @Override
    public Auditorium save(Auditorium auditorium) {
        if (auditorium.isNew()) {
            add(auditorium);
        } else {
            delete(auditorium.getId());
            add(auditorium);
        }
        return auditorium;
    }

    @Override
    public void delete(int id) {
        InMemoryDataBaseSimulator.getAuditoriums().remove(getById(id));
    }

}

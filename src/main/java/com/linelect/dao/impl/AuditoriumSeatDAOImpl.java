package com.linelect.dao.impl;

import com.linelect.dao.AuditoriumSeatDAO;
import com.linelect.dao.InMemoryDataBaseSimulator;
import com.linelect.model.Auditorium;
import com.linelect.model.AuditoriumSeat;
import com.linelect.model.SeatType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuditoriumSeatDAOImpl implements AuditoriumSeatDAO {
    private int id = 1;

    @Override
    public List<AuditoriumSeat> getAll() {
        return InMemoryDataBaseSimulator.getAuditoriumSeats();
    }

    @Override
    public List<AuditoriumSeat> getByAuditorium(Auditorium auditorium) {
        return InMemoryDataBaseSimulator.getAuditoriumSeats().stream()
                .filter(auditoriumSeat -> auditoriumSeat.getAuditorium().equals(auditorium))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuditoriumSeat> getBySeatType(SeatType seatType) {
        return InMemoryDataBaseSimulator.getAuditoriumSeats().stream()
                .filter(auditoriumSeat -> auditoriumSeat.getSeatType().equals(seatType))
                .collect(Collectors.toList());
    }

    @Override
    public AuditoriumSeat getById(int id) {
        return InMemoryDataBaseSimulator.getAuditoriumSeats().stream()
                .filter(auditoriumSeat -> auditoriumSeat.getId() == id)
                .findFirst()
                .orElse(new AuditoriumSeat());
    }

    @Override
    public AuditoriumSeat add(AuditoriumSeat auditoriumSeat) {
        auditoriumSeat.setId(id++);
        InMemoryDataBaseSimulator.getAuditoriumSeats().add(auditoriumSeat);
        return auditoriumSeat;
    }

    @Override
    public AuditoriumSeat save(AuditoriumSeat auditoriumSeat) {
        if (auditoriumSeat.isNew()) {
            add(auditoriumSeat);
        } else {
            delete(auditoriumSeat.getId());
            add(auditoriumSeat);
        }
        return auditoriumSeat;
    }

    @Override
    public void delete(int id) {
        InMemoryDataBaseSimulator.getAuditoriumSeats().remove(getById(id));
    }
}

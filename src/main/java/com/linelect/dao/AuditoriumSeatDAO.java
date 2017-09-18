package com.linelect.dao;

import com.linelect.model.Auditorium;
import com.linelect.model.AuditoriumSeat;
import com.linelect.model.SeatType;

import java.util.List;

public interface AuditoriumSeatDAO {
    List<AuditoriumSeat> getAll();

    List<AuditoriumSeat> getByAuditorium(Auditorium auditorium);

    List<AuditoriumSeat> getBySeatType(SeatType seatType);

    AuditoriumSeat getById(int id);

    AuditoriumSeat add(AuditoriumSeat auditoriumSeat);

    AuditoriumSeat save(AuditoriumSeat auditoriumSeat);

    void delete(int id);
}

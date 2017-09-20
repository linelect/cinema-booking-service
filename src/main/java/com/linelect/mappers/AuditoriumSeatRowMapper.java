package com.linelect.mappers;

import com.linelect.dao.AuditoriumDAO;
import com.linelect.model.AuditoriumSeat;
import com.linelect.model.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AuditoriumSeatRowMapper implements RowMapper<AuditoriumSeat> {

    @Autowired
    private AuditoriumDAO auditoriumDAO;

    @Override
    public AuditoriumSeat mapRow(ResultSet resultSet, int i) throws SQLException {
        AuditoriumSeat auditoriumSeat = new AuditoriumSeat();
        auditoriumSeat.setId(resultSet.getInt("id"));
        auditoriumSeat.setNumber(resultSet.getInt("number"));
        auditoriumSeat.setRow(resultSet.getInt("seat_row"));
        auditoriumSeat.setSeatType(SeatType.valueOf(resultSet.getString("seat_type")));
        auditoriumSeat.setAuditorium(auditoriumDAO.getById(resultSet.getInt("auditorium_id")));
        return null;
    }
}

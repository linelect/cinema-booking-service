package com.linelect.mappers;

import com.linelect.model.Auditorium;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditoriumRowMapper implements RowMapper<Auditorium> {
    @Override
    public Auditorium mapRow(ResultSet resultSet, int i) throws SQLException {
        Auditorium auditorium = new Auditorium();
        auditorium.setId(resultSet.getInt("id"));
        auditorium.setName(resultSet.getString("name"));
        auditorium.setNumberOfSeats(resultSet.getInt("number_seats"));
        return auditorium;
    }
}

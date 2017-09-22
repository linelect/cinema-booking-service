package com.linelect.mappers;

import com.linelect.dao.AuditoriumSeatDAO;
import com.linelect.model.Auditorium;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditoriumRowMapper implements RowMapper<Auditorium> {

    private AuditoriumSeatDAO auditoriumSeatDAO;

    public AuditoriumRowMapper(AuditoriumSeatDAO auditoriumSeatDAO) {
        this.auditoriumSeatDAO = auditoriumSeatDAO;
    }

    @Override
    public Auditorium mapRow(ResultSet resultSet, int i) throws SQLException {
        Auditorium auditorium = new Auditorium();
        auditorium.setId(resultSet.getInt("id"));
        auditorium.setName(resultSet.getString("name"));
        auditorium.setSeatList(auditoriumSeatDAO.getByAuditorium(auditorium));
        return auditorium;
    }
}

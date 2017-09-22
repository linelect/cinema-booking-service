package com.linelect.mappers;

import com.linelect.dao.AuditoriumDAO;
import com.linelect.model.Event;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EventRowMapper implements RowMapper<Event> {

    private AuditoriumDAO auditoriumDAO;

    public EventRowMapper(AuditoriumDAO auditoriumDAO) {
        this.auditoriumDAO = auditoriumDAO;
    }

    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getInt("id"));
        event.setName(resultSet.getString("name"));
        event.setPrice(resultSet.getDouble("price"));
        event.setDateTime(resultSet.getTimestamp("date_time").toLocalDateTime());
        event.setAuditorium(auditoriumDAO.getById(resultSet.getInt("auditorium_id")));
        return event;
    }
}

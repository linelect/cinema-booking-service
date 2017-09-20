package com.linelect.mappers;

import com.linelect.dao.AuditoriumDAO;
import com.linelect.dao.UserDAO;
import com.linelect.model.Event;
import com.linelect.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EventRowMapper implements RowMapper<Event> {

    //    test inject another bean
    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private AuditoriumDAO auditoriumDAO;

//    test inject another bean
    @Autowired
    private UserDAO userDAO;

    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getInt("id"));
        event.setName(resultSet.getString("name"));
        event.setPrice(resultSet.getDouble("price"));
        event.setDateTime(resultSet.getTimestamp("date_time").toLocalDateTime());
//        event.setAuditorium(auditoriumDAO.getById(resultSet.getInt("auditorium_id")));
        return event;
    }
}

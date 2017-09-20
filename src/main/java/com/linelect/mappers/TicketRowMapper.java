package com.linelect.mappers;

import com.linelect.dao.AuditoriumSeatDAO;
import com.linelect.dao.EventDAO;
import com.linelect.dao.UserDAO;
import com.linelect.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TicketRowMapper implements RowMapper<Ticket> {

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AuditoriumSeatDAO auditoriumSeatDAO;

    @Override
    public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(resultSet.getInt("id"));
        ticket.setEvent(eventDAO.getById(resultSet.getInt("event_id")));
        ticket.setAuditoriumSeat(auditoriumSeatDAO.getById(resultSet.getInt("auditorium_seat_id")));
        ticket.setUser(userDAO.getById(resultSet.getInt("user_id")));
        return ticket;
    }
}

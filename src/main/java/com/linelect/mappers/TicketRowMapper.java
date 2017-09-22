package com.linelect.mappers;

import com.linelect.dao.AuditoriumSeatDAO;
import com.linelect.dao.EventDAO;
import com.linelect.dao.UserDAO;
import com.linelect.model.Ticket;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TicketRowMapper implements RowMapper<Ticket> {

    private EventDAO eventDAO;
    private UserDAO userDAO;
    private AuditoriumSeatDAO auditoriumSeatDAO;

    public TicketRowMapper(EventDAO eventDAO, UserDAO userDAO, AuditoriumSeatDAO auditoriumSeatDAO) {
        this.eventDAO = eventDAO;
        this.userDAO = userDAO;
        this.auditoriumSeatDAO = auditoriumSeatDAO;
    }

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

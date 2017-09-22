package com.linelect.dao.impl.jdbc;

import com.linelect.dao.AuditoriumSeatDAO;
import com.linelect.dao.EventDAO;
import com.linelect.dao.TicketDAO;
import com.linelect.dao.UserDAO;
import com.linelect.mappers.AuditoriumSeatRowMapper;
import com.linelect.mappers.EventRowMapper;
import com.linelect.mappers.TicketRowMapper;
import com.linelect.model.Event;
import com.linelect.model.Ticket;
import com.linelect.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

@Component
@Primary
public class TicketJdbcDAOImpl implements TicketDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AuditoriumSeatDAO auditoriumSeatDAO;

    @Override
    public Ticket save(Ticket ticket) {
        String sqlQuery = "UPDATE tickets SET event_id = ?, auditorium_seat_id = ?, user_id = ?, payed = ? where id = ?";
        jdbcTemplate.update(sqlQuery, ticket.getEvent().getId(), ticket.getAuditoriumSeat().getId(), ticket.getUser().getId(),
                ticket.isPayed());
        return ticket;
    }

    @Override
    public Ticket add(Ticket ticket) {
        String sqlQuery = "INSERT INTO tickets(event_id, auditorium_seat_id, user_id, payed) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, ticket.getEvent().getId());
            preparedStatement.setInt(2, ticket.getAuditoriumSeat().getId());
            preparedStatement.setInt(3, ticket.getUser().getId());
            preparedStatement.setBoolean(4, ticket.isPayed());
            return preparedStatement;
        }, keyHolder);
        ticket.setId(keyHolder.getKeyList().size() == 0 ? null : (Integer) keyHolder.getKeyList().get(0).get("id"));
        return ticket;
    }

    @Override
    public void delete(int id) {
        String sqlQuery = "DELETE FROM tickets where id = ?";
        jdbcTemplate.update(sqlQuery, id);
    }

    @Override
    public Ticket getById(int id) {
        String sqlQuery = "Select * from tickets WHERE id = ?";
        List<Ticket> tickets = jdbcTemplate.query(sqlQuery, new Object[]{id}, new TicketRowMapper(eventDAO, userDAO, auditoriumSeatDAO));
        return tickets.size() > 0 ? tickets.get(0) : null;
    }

    @Override
    public List<Ticket> getAll() {
        String sqlQuery = "Select * from tickets";
        return jdbcTemplate.query(sqlQuery, new TicketRowMapper(eventDAO, userDAO, auditoriumSeatDAO));
    }

    @Override
    public List<Ticket> getTicketsByEvent(Event event) {
        String sqlQuery = "Select * from tickets WHERE event_id = ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{event.getId()}, new TicketRowMapper(eventDAO, userDAO, auditoriumSeatDAO));
    }

    @Override
    public List<Ticket> getTicketsByUser(User user) {
        String sqlQuery = "Select * from tickets WHERE user_id = ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{user.getId()}, new TicketRowMapper(eventDAO, userDAO, auditoriumSeatDAO));
    }
}

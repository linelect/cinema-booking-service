package com.linelect.dao.impl.jdbc;

import com.linelect.dao.EventDAO;
import com.linelect.mappers.EventRowMapper;
import com.linelect.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Primary
public class EventJdbcDAOImpl implements EventDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Event save(Event event) {
        String sqlquery = "UPDATE events SET name = ?, price = ?, date_time = ?, auditorium_id = ? where id = ?";
        jdbcTemplate.update(sqlquery, event.getName(), event.getPrice(), Timestamp.valueOf(event.getDateTime()),
                event.getAuditorium().getId());
        return event;
    }

    @Override
    public Event add(Event event) {
        String sqlquery = "INSERT INTO events(name, price, date_time, auditorium_id) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlquery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, event.getName());
            preparedStatement.setDouble(2, event.getPrice());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(event.getDateTime()));
            preparedStatement.setInt(4, event.getAuditorium().getId());
            return preparedStatement;
        }, keyHolder);
        event.setId(keyHolder.getKeyList().size() == 0 ? null : (Integer) keyHolder.getKeyList().get(0).get("id"));
        return event;
    }

    @Override
    public void delete(int id) {
        String sqlquery = "DELETE FROM events where id = ?";
        jdbcTemplate.update(sqlquery, id);
    }

    @Override
    public Event getById(int id) {
        String sqlquery = "Select * from events WHERE id = ?";
        List<Event> events = jdbcTemplate.query(sqlquery, new Object[]{id}, new EventRowMapper());
        return events.size() > 0 ? events.get(0) : null;
    }

    @Override
    public List<Event> getAll() {
        String sqlquery = "Select * from events";
        return jdbcTemplate.query(sqlquery, new EventRowMapper());
    }

    @Override
    public Event getByName(String name) {
        String sqlquery = "Select * from events WHERE name = ?";
        List<Event> events = jdbcTemplate.query(sqlquery, new Object[]{name}, new EventRowMapper());
        return events.size() > 0 ? events.get(0) : null;
    }

    @Override
    public List<Event> getForDateTimeRange(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        String sqlquery = "Select * from events WHERE date_time >= ? and date_time <= ?";
        return jdbcTemplate.query(sqlquery, new Object[]{fromDateTime, toDateTime}, new EventRowMapper());
    }

    @Override
    public List<Event> getNextEvents(LocalDateTime dateTime) {
        String sqlquery = "Select * from events WHERE date_time >= ?";
        return jdbcTemplate.query(sqlquery, new Object[]{dateTime}, new EventRowMapper());
    }
}

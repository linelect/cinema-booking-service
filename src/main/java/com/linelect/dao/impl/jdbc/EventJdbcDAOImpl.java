package com.linelect.dao.impl.jdbc;

import com.linelect.dao.AuditoriumDAO;
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

    @Autowired
    private AuditoriumDAO auditoriumDAO;

    @Override
    public Event save(Event event) {
        String sqlQuery = "UPDATE events SET name = ?, price = ?, date_time = ?, auditorium_id = ? where id = ?";
        jdbcTemplate.update(sqlQuery, event.getName(), event.getPrice(), Timestamp.valueOf(event.getDateTime()),
                event.getAuditorium().getId());
        return event;
    }

    @Override
    public Event add(Event event) {
        String sqlQuery = "INSERT INTO events(name, price, date_time, auditorium_id) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
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
        String sqlQuery = "DELETE FROM events where id = ?";
        jdbcTemplate.update(sqlQuery, id);
    }

    @Override
    public Event getById(int id) {
        String sqlQuery = "Select * from events WHERE id = ?";
        List<Event> events = jdbcTemplate.query(sqlQuery, new Object[]{id}, new EventRowMapper(auditoriumDAO));
        return events.size() > 0 ? events.get(0) : null;
    }

    @Override
    public List<Event> getAll() {
        String sqlQuery = "Select * from events";
        return jdbcTemplate.query(sqlQuery, new EventRowMapper(auditoriumDAO));
    }

    @Override
    public Event getByName(String name) {
        String sqlQuery = "Select * from events WHERE name = ?";
        List<Event> events = jdbcTemplate.query(sqlQuery, new Object[]{name}, new EventRowMapper(auditoriumDAO));
        return events.size() > 0 ? events.get(0) : null;
    }

    @Override
    public List<Event> getForDateTimeRange(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        String sqlQuery = "Select * from events WHERE date_time >= ? and date_time <= ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{fromDateTime, toDateTime}, new EventRowMapper(auditoriumDAO));
    }

    @Override
    public List<Event> getNextEvents(LocalDateTime dateTime) {
        String sqlQuery = "Select * from events WHERE date_time >= ?";
        return jdbcTemplate.query(sqlQuery, new Object[]{dateTime}, new EventRowMapper(auditoriumDAO));
    }
}

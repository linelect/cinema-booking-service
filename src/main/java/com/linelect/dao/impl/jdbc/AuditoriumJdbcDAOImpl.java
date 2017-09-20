package com.linelect.dao.impl.jdbc;

import com.linelect.dao.AuditoriumDAO;
import com.linelect.dao.impl.mappers.AuditoriumRowMapper;
import com.linelect.model.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Component
@Primary
public class AuditoriumJdbcDAOImpl implements AuditoriumDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Auditorium> getAll() {
        String sqlquery = "Select * from auditoriums";
        return jdbcTemplate.query(sqlquery, new AuditoriumRowMapper());
    }

    @Override
    public Auditorium getById(int id) {
        String sqlquery = "Select * from auditoriums WHERE id = ?";
        List<Auditorium> auditoriums = jdbcTemplate.query(sqlquery, new Object[]{id}, new AuditoriumRowMapper());
        return auditoriums.size() > 0 ? auditoriums.get(0) : null;
    }

    @Override
    public Auditorium add(Auditorium auditorium) {
        String sqlquery = "INSERT INTO auditoriums(name, number_seats) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int update = jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlquery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, auditorium.getName());
            preparedStatement.setDouble(2, auditorium.getNumberOfSeats());
            return preparedStatement;
        }, keyHolder);
        auditorium.setId(keyHolder.getKeyList().size() == 0 ? null : (Integer) keyHolder.getKeyList().get(0).get("id"));
        return auditorium;
    }

    @Override
    public Auditorium save(Auditorium auditorium) {
        String sqlquery = "UPDATE auditoriums SET name = ?, number_seats = ? where id = ?";
        jdbcTemplate.update(sqlquery, auditorium.getName(), auditorium.getNumberOfSeats(), auditorium.getId());
        return auditorium;
    }

    @Override
    public void delete(int id) {
        String sqlquery = "DELETE FROM auditoriums where id = ?";
        jdbcTemplate.update(sqlquery, id);
    }
}

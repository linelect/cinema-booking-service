package com.linelect.dao.impl.jdbc;

import com.linelect.dao.AuditoriumDAO;
import com.linelect.dao.AuditoriumSeatDAO;
import com.linelect.mappers.AuditoriumRowMapper;
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

    @Autowired
    private AuditoriumSeatDAO auditoriumSeatDAO;

    @Override
    public List<Auditorium> getAll() {
        String sqlQuery = "Select * from auditoriums";
        return jdbcTemplate.query(sqlQuery, new AuditoriumRowMapper(auditoriumSeatDAO));
    }

    @Override
    public Auditorium getById(int id) {
        String sqlQuery = "Select * from auditoriums WHERE id = ?";
        List<Auditorium> auditoriums = jdbcTemplate.query(sqlQuery, new Object[]{id}, new AuditoriumRowMapper(auditoriumSeatDAO));
        return auditoriums.size() > 0 ? auditoriums.get(0) : null;
    }

    @Override
    public Auditorium add(Auditorium auditorium) {
        String sqlQuery = "INSERT INTO auditoriums(name) VALUES (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int update = jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, auditorium.getName());
            return preparedStatement;
        }, keyHolder);
        auditorium.setId(keyHolder.getKeyList().size() == 0 ? null : (Integer) keyHolder.getKeyList().get(0).get("id"));
        return auditorium;
    }

    @Override
    public Auditorium save(Auditorium auditorium) {
        String sqlQuery = "UPDATE auditoriums SET name = ? where id = ?";
        jdbcTemplate.update(sqlQuery, auditorium.getName(), auditorium.getId());
        return auditorium;
    }

    @Override
    public void delete(int id) {
        String sqlQuery = "DELETE FROM auditoriums where id = ?";
        jdbcTemplate.update(sqlQuery, id);
    }
}

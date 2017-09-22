package com.linelect.dao.impl.jdbc;

import com.linelect.dao.UserDAO;
import com.linelect.mappers.UserRowMapper;
import com.linelect.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Component
@Primary
public class UserJdbcDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User save(User user) {
        String sqlQuery = "UPDATE USERS SET name = ?, email = ? where id = ?";
        jdbcTemplate.update(sqlQuery, user.getName(), user.getEmail(), user.getId());
        return user;
    }

    @Override
    public User add(User user) {
        String sqlQuery = "INSERT INTO users(name, email) VALUES (?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            return statement;
        }, keyHolder);
        user.setId(keyHolder.getKeyList().size() == 0 ? null : (Integer) keyHolder.getKeyList().get(0).get("id"));
        return user;
    }

    @Override
    public void delete(int id) {
        String sqlQuery = "DELETE FROM USERS where id = ?";
        jdbcTemplate.update(sqlQuery, id);
    }

    @Override
    public User getById(int id) {
        String sqlQuery = "Select * from users WHERE id = ?";
        List<User> users = jdbcTemplate.query(sqlQuery, new Object[]{id}, new UserRowMapper());
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public User getByEmail(String email) {
        String sqlQuery = "Select * from users WHERE email = ?";
        List<User> users = jdbcTemplate.query(sqlQuery, new Object[]{email}, new UserRowMapper());
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public List<User> getAll() {
        String sqlQuery = "Select * from users";
        return jdbcTemplate.query(sqlQuery, new UserRowMapper());
    }
}

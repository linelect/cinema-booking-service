package com.linelect.dao.impl.jdbc;

import com.linelect.dao.AuditoriumSeatDAO;
import com.linelect.mappers.AuditoriumSeatRowMapper;
import com.linelect.mappers.EventRowMapper;
import com.linelect.model.Auditorium;
import com.linelect.model.AuditoriumSeat;
import com.linelect.model.Event;
import com.linelect.model.SeatType;
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
public class AuditoriumSeatJdbcDAOImpl implements AuditoriumSeatDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<AuditoriumSeat> getAll() {
        String sqlquery = "Select * from auditorium_seats";
        return jdbcTemplate.query(sqlquery, new AuditoriumSeatRowMapper());
    }

    @Override
    public List<AuditoriumSeat> getByAuditorium(Auditorium auditorium) {
        String sqlquery = "Select * from auditorium_seats WHERE auditorium_id = ?";
        return jdbcTemplate.query(sqlquery, new Object[]{auditorium.getId()}, new AuditoriumSeatRowMapper());
    }

    @Override
    public List<AuditoriumSeat> getBySeatType(SeatType seatType) {
        String sqlquery = "Select * from auditorium_seats WHERE seat_type = ?";
        return jdbcTemplate.query(sqlquery, new Object[]{seatType.name()}, new AuditoriumSeatRowMapper());
    }

    @Override
    public AuditoriumSeat getById(int id) {
        String sqlquery = "Select * from auditorium_seats WHERE id = ?";
        List<AuditoriumSeat> auditoriumSeats = jdbcTemplate.query(sqlquery, new Object[]{id}, new AuditoriumSeatRowMapper());
        return auditoriumSeats.size() > 0 ? auditoriumSeats.get(0) : null;
    }

    @Override
    public AuditoriumSeat add(AuditoriumSeat auditoriumSeat) {
        String sqlquery = "INSERT INTO auditorium_seats(number, seat_row, auditorium_id, seat_type) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlquery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, auditoriumSeat.getNumber());
            preparedStatement.setInt(2, auditoriumSeat.getRow());
            preparedStatement.setInt(3, auditoriumSeat.getAuditorium().getId());
            preparedStatement.setString(4, auditoriumSeat.getSeatType().name());
            return preparedStatement;
        }, keyHolder);
        auditoriumSeat.setId(keyHolder.getKeyList().size() == 0 ? null : (Integer) keyHolder.getKeyList().get(0).get("id"));
        return auditoriumSeat;
    }

    @Override
    public AuditoriumSeat save(AuditoriumSeat auditoriumSeat) {
        String sqlquery = "UPDATE auditorium_seats SET number = ?, seat_row = ?, auditorium_id = ?, seat_type = ? where id = ?";
        jdbcTemplate.update(sqlquery, auditoriumSeat.getNumber(), auditoriumSeat.getRow(), auditoriumSeat.getAuditorium().getId(),
                auditoriumSeat.getSeatType().ordinal());
        return auditoriumSeat;
    }

    @Override
    public void delete(int id) {
        String sqlquery = "DELETE FROM auditorium_seats where id = ?";
        jdbcTemplate.update(sqlquery, id);
    }
}

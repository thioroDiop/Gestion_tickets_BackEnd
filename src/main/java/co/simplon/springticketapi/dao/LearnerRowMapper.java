package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Learner;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LearnerRowMapper implements RowMapper<Learner> {

    @Override
    public Learner mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Learner(resultSet.getLong("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getLong("classroom_idx"));
    }
}

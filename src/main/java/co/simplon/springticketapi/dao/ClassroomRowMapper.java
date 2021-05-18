package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Classroom;
import co.simplon.springticketapi.model.Learner;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ClassroomRowMapper implements RowMapper<Classroom> {

    @Override
    public Classroom mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Classroom(resultSet.getLong("id"), resultSet.getString("name"));
    }
}

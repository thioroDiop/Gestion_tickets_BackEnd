package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Classroom;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Component
public class ClassroomDao implements Dao<Classroom> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Classroom> classroomRowMapper;

    public ClassroomDao(JdbcTemplate jdbcTemplate, RowMapper<Classroom> classroomRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.classroomRowMapper = classroomRowMapper;
    }

    @Override
    public Classroom get(Long id) {
        return jdbcTemplate.queryForObject("SELECT * from classroom where id = ?", classroomRowMapper, id);
    }

    @Override
    public List<Classroom> getAll() {
        return jdbcTemplate.query("select * from classroom", classroomRowMapper);
    }

    @Override
    public Classroom save(Classroom classroom) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO classroom (name) VALUES (?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, classroom.getName());
            return ps;
        }, keyHolder);

        Long id = ((Integer) keyHolder.getKeys().get("id")).longValue();
        classroom.setId(id);
        return classroom;

        // INSERT INTO classroom (name) VALUES ('La Poste P5')
        // jdbcTemplate.update("INSERT INTO classroom (name) VALUES ('"+classroom.getName()+"')");
        // return classroom;
    }

    @Override
    public void delete(Long id) {
        String deleteStatement = "DELETE FROM classroom WHERE id = ?";
        jdbcTemplate.update(deleteStatement, id);
    }

    // -------- J'ai rempli le contrat DAO --------

}

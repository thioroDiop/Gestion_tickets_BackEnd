package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

@Component
public class TicketDao implements Dao<Ticket> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Ticket> ticketRowMapper;

    public TicketDao(JdbcTemplate jdbcTemplate, RowMapper<Ticket> ticketRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.ticketRowMapper = ticketRowMapper;
    }

    @Override
    public Ticket get(Long id) {
        return jdbcTemplate.queryForObject("select * from ticket where id = ?", ticketRowMapper, id);
    }

    @Override
    public List<Ticket> getAll() {
        return jdbcTemplate.query("select * from ticket", ticketRowMapper);
    }

    @Override
    public Ticket save(Ticket ticket) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO ticket (date, description, is_solved, learner_idx) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setTimestamp(1, Timestamp.valueOf(ticket.getDate()));
            ps.setString(2, ticket.getDescription());
            ps.setBoolean(3, ticket.isSolved());
            ps.setLong(4, ticket.getLearnerIdx());

            return ps;
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);

        Integer id = (Integer) keyHolder.getKeys().get("id");
        ticket.setId(id.longValue());

        return ticket;
    }

    public Ticket updateTicketStatus(Ticket ticket) {
        jdbcTemplate.update("UPDATE ticket set is_solved = ?", ticket.isSolved());
        return ticket;
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE from ticket where id = ?", id);
    }
}

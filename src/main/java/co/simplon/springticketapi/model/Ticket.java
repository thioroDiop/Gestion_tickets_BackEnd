package co.simplon.springticketapi.model;

import java.time.LocalDateTime;

public class Ticket {
    private Long id;
    private LocalDateTime date;
    private String description;
    private boolean solved;
    private Long learnerIdx;

    public Ticket(Long id, LocalDateTime date, String description, boolean solved, Long learnerIdx) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.solved = solved;
        this.learnerIdx = learnerIdx;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSolved() {
        return solved;
    }

    public Long getLearnerIdx() {
        return learnerIdx;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

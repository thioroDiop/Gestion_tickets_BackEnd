package co.simplon.springticketapi.model;

public class Classroom {
    private Long id;
    private String name;

    public Classroom(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

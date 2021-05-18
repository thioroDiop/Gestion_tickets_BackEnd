package co.simplon.springticketapi.model;

public class Learner {
    private Long id;
    private String firstName;
    private String lastName;
    private Long classroomIdx;

    public Learner(Long id, String firstName, String lastName, Long classroomIdx) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classroomIdx = classroomIdx;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getClassroomIdx() {
        return classroomIdx;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package bean;

public class Task {

    private int id;

    private String description;

    private int hours;

    private PersonExt person;

    public Task() {

    }

    public Task(String description, int hours) {
        this.description = description;
        this.hours = hours;
    }

    public Task(String description, int hours, PersonExt person) {
        this.description = description;
        this.hours = hours;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public PersonExt getPerson() {
        return person;
    }

    public void setPerson(PersonExt person) {
        this.person = person;
    }
}

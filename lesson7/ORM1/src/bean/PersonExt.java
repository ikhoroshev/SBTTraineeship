package bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 20.04.2016.
 */
public class PersonExt {

    private int id;

    private String name;

    private int salary;

    private Date sinceDt;

    private Set<Task> tasks = new HashSet<Task>(0);

    public PersonExt() {
    }

    public PersonExt(String name, int salary, Date since_dt) {
        this.name = name;
        this.salary = salary;
        this.sinceDt = since_dt;
    }

    public PersonExt(String name, int salary, Date since_dt, Set<Task> tasks) {
        this.name = name;
        this.salary = salary;
        this.sinceDt = since_dt;
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getSinceDt() {
        return sinceDt;
    }

    public void setSinceDt(Date sinceDt) {
        this.sinceDt = sinceDt;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}

package bean;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 20.04.2016.
 */
public class Person {

    private int id;

    private String name;

    private int salary;

    private Date sinceDt;

    public Person() {
    }

    public Person(String name, int salary, Date since_dt) {
        this.name = name;
        this.salary = salary;
        this.sinceDt = since_dt;
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
}

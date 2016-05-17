package ru.sberbank.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Idony on 13.05.2016.
 */
@Entity
public class SystemLog {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false,name = "data_time")
    private Date dateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public SystemLog(String code, String message, Date dateTime, User user) {
        this.code = code;
        this.message = message;
        this.dateTime = dateTime;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

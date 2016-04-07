package ru.sberbank.model;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

/**
 * Created by sbt-shmygin-as on 06.04.2016.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade=CascadeType.ALL)
    private UserGroup userGroup;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String middleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}

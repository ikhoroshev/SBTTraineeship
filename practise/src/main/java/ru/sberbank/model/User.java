package ru.sberbank.model;

import javax.persistence.*;

/**
 * Created by sbt-shmygin-as on 06.04.2016.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade=CascadeType.ALL)
    private UserGroup group;
    @Column(nullable = false)
    private String name;

    protected User() {};

    public User(UserGroup userGroup, String firstName, String lastName, String middleName) {
        this.userGroup = userGroup;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserGroup getGroup() {
        return group;
    }

    public void setGroup(UserGroup group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

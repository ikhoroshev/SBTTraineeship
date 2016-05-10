package ru.sberbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by sbt-shmygin-as on 06.04.2016.
 */
@Entity
public class UserGroup {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    private UserGroupType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserGroupType getType() {
        return type;
    }

    public void setType(UserGroupType type) {
        this.type = type;
    }
}

package ru.sberbank.model;

import javax.persistence.*;

@Entity
@Table(name = "USER_GROUP")
public class UserGroup {
    @Id @GeneratedValue
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

package ru.sberbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by sbt-shmygin-as on 06.04.2016.
 */
@Entity(name = "user_group")
public class UserGroup {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGroup userGroup = (UserGroup) o;

        if (id != null ? !id.equals(userGroup.id) : userGroup.id != null) return false;
        return name != null ? name.equals(userGroup.name) : userGroup.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}

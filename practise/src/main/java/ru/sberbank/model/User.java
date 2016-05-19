package ru.sberbank.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by sbt-shmygin-as on 06.04.2016.
 */
@Entity
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String middleName;
  @Column(nullable = false)
  private String lastName;
  @ManyToOne
  private UserGroup group;

  protected User() {};

  public User(UserGroup userGroup, String firstName, String lastName, String middleName) {
    this.group = userGroup;
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

  public void setGroup(UserGroup userGroup) {
    this.group = userGroup;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}

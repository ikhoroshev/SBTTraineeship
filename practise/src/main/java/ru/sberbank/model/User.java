package ru.sberbank.model;

/**
 * Created by sbt-shmygin-as on 06.04.2016.
 */
public class User {
  private Long id;
  private String firstName;
  private String middleName;
  private String lastName;
  private UserGroup userGroup;

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
    return userGroup;
  }

  public void setGroup(UserGroup userGroup) {
    this.userGroup = userGroup;
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

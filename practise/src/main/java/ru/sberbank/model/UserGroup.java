package ru.sberbank.model;

/**
 * Created by sbt-shmygin-as on 06.04.2016.
 */
public class UserGroup {
  private Long id;
  private String groupName;

  public Long getId() {
      return id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

}

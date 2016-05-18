/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Raim
 */
@Entity
class TestRun {
  @Id
  @GeneratedValue
  private Long id;
  @ManyToOne
  private User user;
  @ManyToOne
  private Test test;
  @Column(nullable = false)
  private TestRunStatus testRunStatus;
  
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Test getTest() {
    return test;
  }

  public void setTest(Test test) {
    this.test = test;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TestRunStatus getTestRunStatus() {
    return testRunStatus;
  }

  public void setTestRunStatus(TestRunStatus testRunStatus) {
    this.testRunStatus = testRunStatus;
  }
  
}

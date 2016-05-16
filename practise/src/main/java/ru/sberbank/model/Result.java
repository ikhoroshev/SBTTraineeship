/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.model;

/**
 *
 * @author Raim
 */
class Result {
  private User user;
  private TestRun testRun;
  private Question question;
  private Answer Answer;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public TestRun getTestRun() {
    return testRun;
  }

  public void setTestRun(TestRun testRun) {
    this.testRun = testRun;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public Answer getAnswer() {
    return Answer;
  }

  public void setAnswer(Answer Answer) {
    this.Answer = Answer;
  }
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.model;

import java.util.List;

/**
 *
 * @author Raim
 */
class Question {
  private Long id;
  private List<Answer> answers;
  private TestChapter testChapter;
  private String text;
  private Test test;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

  public TestChapter getTestChapter() {
    return testChapter;
  }

  public void setTestChapter(TestChapter testChapter) {
    this.testChapter = testChapter;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Test getTest() {
    return test;
  }

  public void setTest(Test test) {
    this.test = test;
  }
  
}

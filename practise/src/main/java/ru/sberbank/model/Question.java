/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question {
  @Id
  @GeneratedValue
  private Long id;
  @OneToMany
  private List<Answer> answers;
  @ManyToOne
  private TestChapter testChapter;
  @Column(nullable = false)
  private String text;
  @ManyToOne
  private Test test;
  @Column(nullable = false)
  private AnswerType answerType;



    @Column(nullable = false)
    private String text2;


    public Long getId()
    {
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

  public AnswerType getAnswerType() {
    return answerType;
  }

  public void setAnswerType(AnswerType answerType) {
    this.answerType = answerType;
  }
  
}

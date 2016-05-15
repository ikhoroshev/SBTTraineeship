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
class Answer {
  private Long id;
  private Question question;
  private String text;
  private Boolean isRight;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Boolean getIsRight() {
    return isRight;
  }

  public void setIsRight(Boolean isRight) {
    this.isRight = isRight;
  }
  
}

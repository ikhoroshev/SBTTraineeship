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
class Answer {
  @Id
  @GeneratedValue
  private Long id;
  @ManyToOne
  private Question question;
  @Column(nullable = false)
  private String text;
  @Column(nullable = false)
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

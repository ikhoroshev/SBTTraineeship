package ru.sberbank.model;

import javax.persistence.*;

/**
 * Created by asphodelfod on 16.05.16.
 */
@Entity
public class Answer {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID", nullable = false)
    private Question question;

    @Column(nullable = false)
    private String text;

    @Column(name = "IS_RIGHT")
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

    public Boolean getRight() {
        return isRight;
    }

    public void setRight(Boolean right) {
        isRight = right;
    }
}

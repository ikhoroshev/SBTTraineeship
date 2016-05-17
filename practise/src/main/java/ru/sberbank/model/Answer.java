package ru.sberbank.model;

import javax.persistence.*;

/**
 * Created by Idony on 13.05.2016.
 */
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false,name = "is_right")
    private Boolean isRight;
    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;

    public Answer(String text, Boolean is_right) {
        this.text = text;
        this.isRight = is_right;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    protected Answer() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

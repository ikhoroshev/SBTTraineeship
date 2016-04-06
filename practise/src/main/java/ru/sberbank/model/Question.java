package ru.sberbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.lang.String;

@Entity
public class Question {
    @Id
    @GeneratedValue
	private Long id;
    @Column(nullable = false)
	private Long answerId;
    @Column(nullable = false)
    private Long testId;
    @Column(nullable = false)
    private QuestionType type;
    @Column(nullable = false)
	private String text;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getAnswerId()
    {
        return answerId;
    }

    public void setAnswerId(Long answerId)
    {
        this.answerId = answerId;
    }

    public Long getTestId()
    {
        return testId;
    }

    public void setTestId(Long testId)
    {
        this.testId = testId;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
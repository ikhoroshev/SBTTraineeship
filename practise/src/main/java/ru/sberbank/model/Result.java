package ru.sberbank.model;

import javax.persistence.*;

/**
 * Created by Idony on 17.05.2016.
 */
@Entity
public class Result {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private TestRun testRun;

    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;

    @ManyToOne
    private Answer answer;

    public Result(TestRun testRun, Question question, Answer answer) {
        this.testRun = testRun;
        this.question = question;
        this.answer = answer;
    }
    public Result(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}

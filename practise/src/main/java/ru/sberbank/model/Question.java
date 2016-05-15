package ru.sberbank.model;

import javax.persistence.*;
import java.lang.String;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "question")
    //@JoinColumn(name = "ANSWERS_ID", nullable = false)
    private List<Answer> answers;

    @ManyToMany(mappedBy = "questions")
    private List<Test> tests;

    @Column(nullable = false)
    private QuestionType type;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "TEST_CHAPTER_ID", nullable = false)
    private TestChapter testChapter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Answer> getAnswers() { return answers; }

    public void setAnswers(List<Answer> answers) { this.answers = answers; }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Test> getTests() { return tests; }

    public void setTests(List<Test> tests) { this.tests = tests; }
}
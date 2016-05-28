package ru.sberbank.model;

import javax.persistence.*;
import java.lang.String;
import java.util.Set;

@Entity
public class Question implements Comparable<Question>{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,name = "answer_type")
    private AnswerType answerType;

    @ManyToOne
    private TestChapter testChapter;

    @OneToMany
    private Set<Answer> answer;

    @Column(nullable = false)
    private String text;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "test_question", catalog = "db",
            joinColumns = {
                    @JoinColumn(name = "question_id", nullable = false, updatable = false) },
            inverseJoinColumns = {
                    @JoinColumn(name = "test_id",nullable = false, updatable = false) })
    private Set<Test> tests;

    public Long getId() {
        return id;
    }

    public Question(AnswerType answerType, TestChapter testChapter, Set<Answer> answer, String text, Set<Test> tests) {
        this.answerType = answerType;
        this.testChapter = testChapter;
        this.answer = answer;
        this.text = text;
        this.tests = tests;
    }
    public Question(){}
    public void setId(Long id) {
        this.id = id;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public TestChapter getTestChapter() {
        return testChapter;
    }

    public void setTestChapter(TestChapter testChapter) {
        this.testChapter = testChapter;
    }

    public Set<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(Set<Answer> answer) {
        this.answer = answer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    @Override
    public int compareTo(Question o) {
        if(testChapter==null)return -1;
        if(o.getTestChapter()==null)return 1;
        int i=testChapter.getPosition().compareTo(o.getTestChapter().getPosition());
        if(i==0)
        {
            return testChapter.getId().compareTo(o.getId());
        }
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return id.equals(question.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
//package ru.sberbank.model;
//
//import javax.persistence.*;
//import java.lang.String;
//import java.util.List;
//
//@Entity
//public class Question extends Test {
//    @Id @GeneratedValue
//    private Long id;
//
//    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Answer> answers;
//
//    @Column(nullable = false)
//    private QuestionType type;
//
//    @Column(nullable = false)
//    private String text;
//
//    @ManyToOne
//    @JoinColumn(name = "TEST_CHAPTER_ID")
//    private TestChapter testChapter;
//
//    public Question() {
//        answers=null;
//        type=null;
//        text=null;
//        testChapter=null;
//    }
//
//    public Question(List<Answer> answers, QuestionType type, String text, TestChapter testChapter) {
//        this.answers = answers;
//        this.type = type;
//        this.text = text;
//        this.testChapter = testChapter;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public List<Answer> getAnswers() { return answers; }
//
//    public void setAnswers(List<Answer> answers) { this.answers = answers; }
//
//    public QuestionType getType() {
//        return type;
//    }
//
//    public void setType(QuestionType type) {
//        this.type = type;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public TestChapter getTestChapter() { return testChapter; }
//
//    public void setTestChapter(TestChapter testChapter) { this.testChapter = testChapter; }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Question question = (Question) o;
//
//        if (!id.equals(question.id)) return false;
//        if (type != question.type) return false;
//        return text.equals(question.text);
//
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id.hashCode();
//        result = 31 * result + type.hashCode();
//        result = 31 * result + text.hashCode();
//        return result;
//    }
//}

package ru.sberbank.model;

import javax.persistence.*;
import java.lang.String;
import java.util.List;

@Entity
public class Question{
    @Id @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Answer> answers;

    @Column(nullable = false)
    private QuestionType type;

    @Column(nullable = false, length = 2000)
    private String text;

    @ManyToOne
    @JoinColumn(name = "TEST_CHAPTER_ID", nullable = false)
    private TestChapter testChapter;

    public Question() {
        answers=null;
        type=null;
        text=null;
        testChapter=null;
    }

    public Question(String text) {
        this.text = text;
    }

    public Question(List<Answer> answers, QuestionType type, String text, TestChapter testChapter) {
        this.answers = answers;
        this.type = type;
        this.text = text;
        this.testChapter = testChapter;
    }

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

    public TestChapter getTestChapter() { return testChapter; }

    public void setTestChapter(TestChapter testChapter) { this.testChapter = testChapter; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (!id.equals(question.id)) return false;
        if (type != question.type) return false;
        return text.equals(question.text);


    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + text.hashCode();
        return result;
    }
}
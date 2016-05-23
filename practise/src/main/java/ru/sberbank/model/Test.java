package ru.sberbank.model;


import javax.persistence.*;
import javax.persistence.Id;
import java.util.List;


@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "test_question", catalog = "db",
            joinColumns = {
                    @JoinColumn(name = "question_id", nullable = false, updatable = false) },
            inverseJoinColumns = {
                    @JoinColumn(name = "test_id",nullable = false, updatable = false) })
    @OrderBy("testChapter.position")
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    public Test (){

    }


    public Test(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

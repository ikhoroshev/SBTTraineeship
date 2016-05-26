package ru.sberbank.model;


import org.hibernate.annotations.SortComparator;
import org.hibernate.annotations.SortNatural;
import org.springframework.data.web.SortDefault;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.List;
import java.util.SortedSet;


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
                    @JoinColumn(name = "test_id", nullable = false, updatable = false) },
            inverseJoinColumns = {
                    @JoinColumn(name = "question_id",nullable = false, updatable = false) })

    @SortNatural
    private SortedSet<Question> questions;

    public SortedSet<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(SortedSet<Question> questions) {
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

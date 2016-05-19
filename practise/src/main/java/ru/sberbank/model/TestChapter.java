package ru.sberbank.model;

import javax.persistence.*;

/**
 * Created by asphodelfod on 16.05.16.
 */

@Entity
@Table(name = "TEST_CHAPTER")
public class TestChapter {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer position;

    public TestChapter() {}

    public TestChapter(String title) { this.title = title; position=0; }

    public TestChapter(String title, Integer position) {
        this.title = title;
        this.position = position;
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}

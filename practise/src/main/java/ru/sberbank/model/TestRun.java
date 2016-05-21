package ru.sberbank.model;

import javax.persistence.*;

/**
 * Created by Idony on 13.05.2016.
 */
@Entity
public class TestRun {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String status;
    @ManyToOne
    private User user;
    @ManyToOne
    private Test test;

    public TestRunStatus getTestRunStatus() {
        return testRunStatus;
    }

    public void setTestRunStatus(TestRunStatus testRunStatus) {
        this.testRunStatus = testRunStatus;
    }

    @Column
    TestRunStatus testRunStatus;

    public TestRun() {return;}

    public TestRun(String status, User user, Test test) {
        this.status = status;
        this.user = user;
        this.test = test;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}


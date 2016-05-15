package ru.sberbank.model;

import javax.persistence.*;

/**
 * Created by asphodelfod on 16.05.16.
 */
@Entity
@Table(name = "TEST_RUN")
public class TestRun {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "TEST_ID", nullable = false)
    private Test test;

    @Column(name = "TEST_RUN_STATUS", nullable = false)
    private TestRunStatus testRunStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TestRunStatus getTestRunStatus() {
        return testRunStatus;
    }

    public void setTestRunStatus(TestRunStatus testRunStatus) {
        this.testRunStatus = testRunStatus;
    }
}

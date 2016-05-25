package ru.sberbank.services;

import ru.sberbank.model.*;

/**
 * Created by Idony on 20.05.2016.
 */

public interface TestRunService {
    Iterable<TestRun> findByUserGroupLike(UserGroup userGroup);
    TestRun findOne(Long id);
    void addOrSaveTestRun(TestRun testRun);
    Question nextQuestion(Long id, TestRun testRun, Answers answer);
    void startTest(Long testRunId,TestRun testRun);
    boolean inspectionAnswer(Answers answers,TestRun testRun);
}

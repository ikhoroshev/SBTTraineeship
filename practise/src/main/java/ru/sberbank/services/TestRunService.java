package ru.sberbank.services;

import ru.sberbank.model.Answer;
import ru.sberbank.model.Question;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.UserGroup;

/**
 * Created by Idony on 20.05.2016.
 */

public interface TestRunService {
    Iterable<TestRun> findByUserGroupLike(UserGroup userGroup);
    TestRun findOne(Long id);
    void addOrSaveTestRun(TestRun testRun);
    Question nextQuestion(Long id, TestRun testRun, Answer answer);
    void startTest(Long testRunId);
}

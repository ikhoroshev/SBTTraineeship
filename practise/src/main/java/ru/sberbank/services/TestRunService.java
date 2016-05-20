package ru.sberbank.services;

import ru.sberbank.model.TestRun;

/**
 * Created by Николай on 19.05.2016.
 */
public interface TestRunService {

    void addTestRun(TestRun testRun);
    void deleteTestRun(Long id);
    Iterable<TestRun> getAllTestRun();
    TestRun getTestRun(Long id);
    Iterable<TestRun> findTestRunById(Long id);
}

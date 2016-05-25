package ru.sberbank.services;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sberbank.model.*;
import ru.sberbank.repositories.TestRepository;
import ru.sberbank.repositories.TestRunRepository;


import javax.annotation.Resource;
import java.util.Iterator;
import java.util.SortedSet;

/**
 * Created by Idony on 20.05.2016.
 */
@Service
public class TestRunServiceImpl implements TestRunService {
    @Resource
    TestRunRepository testRunRepository;
    @Resource
    TestRepository testRepository;

    @Override
    public Iterable<TestRun> findByUserGroupLike(UserGroup userGroup) {
        return testRunRepository.findByUserGroupLike(userGroup);
    }

    @Override
    public TestRun findOne(Long id) {
        return testRunRepository.findOne(id);
    }

    @Override
    public void addOrSaveTestRun(TestRun testRun) {
        testRunRepository.save(testRun);
    }

    @Override
    @Transactional
    public Question nextQuestion(Long testRunId, TestRun testRunn, Answers answers) {
        TestRun testRun = findOne(testRunId);
        Question question = null;
        if (testRun.getTestRunStatus() == TestRunStatus.RUNNING) {

            Test test = testRun.getTest();
            SortedSet<Question> questionList = test.getQuestions();
            Iterator<Question> questionIterable = questionList.iterator();
            question = questionList.first();
            if (testRun.getCurrentQuestion() == null) {
                testRun.setCurrentQuestion(question);
                addOrSaveTestRun(testRun);
                Hibernate.initialize(question.getAnswer());
                return question;
            }

            if (testRun.getCurrentQuestion() != null &&
                    inspectionAnswer(answers, testRun)) {
                for (int i = 0; i < questionList.size(); i++) {
                    if (questionIterable.next().equals(testRun.getCurrentQuestion())) {
                        question = questionIterable.next();
                        testRun.setCurrentQuestion(question);
                        addOrSaveTestRun(testRun);
                        Hibernate.initialize(question.getAnswer());
                        return question;
                    }
                }
            }
            Hibernate.initialize(testRun.getCurrentQuestion().getAnswer());
            return testRun.getCurrentQuestion();
        }
        Hibernate.initialize(testRun.getCurrentQuestion());
        return testRunn.getCurrentQuestion();
    }

    @Override
    public void startTest(Long testRunId,TestRun testRunn) {
        TestRun testRun = findOne(testRunId);
        if (testRun.getTestRunStatus() == TestRunStatus.NEW&&testRunn.getTestRunStatus()==TestRunStatus.RUNNING) {
            testRun.setTestRunStatus(TestRunStatus.RUNNING);
            addOrSaveTestRun(testRun);
        }
    }

    @Override
    public boolean inspectionAnswer(Answers answers,TestRun testRun) {

        //реализовать проверку
        return false;
    }
}
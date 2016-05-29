package ru.sberbank.services;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sberbank.model.*;
import ru.sberbank.repositories.AnswerRepository;
import ru.sberbank.repositories.ResultRepository;
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
    @Resource
    ResultRepository resultRepository;
    @Resource
    AnswerRepository answerRepository;
    @Override
    public Iterable<TestRun> findByUserGroupLike(UserGroup userGroup) {
        return testRunRepository.findByUserGroupLike(userGroup);
    }

    @Override
    public Iterable<TestRun> findByTestsUser(User user) {
        if (user == null) {
            return null;
        }
       return testRunRepository.findByUser(user);
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
                for (;questionIterable.hasNext();) {
                    if (questionIterable.next().equals(testRun.getCurrentQuestion())) {
                        if (questionIterable.hasNext()) {
                            question = questionIterable.next();
                            testRun.setCurrentQuestion(question);
                            addOrSaveTestRun(testRun);
                            Hibernate.initialize(question.getAnswer());
                            return question;
                        }
                        testRun.setTestRunStatus(TestRunStatus.COMPLETED);
                        addOrSaveTestRun(testRun);
                        return null;
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
    public void startTest(Long testRunId, TestRun testRunn) {
        TestRun testRun = findOne(testRunId);
        if (testRun.getTestRunStatus() == TestRunStatus.NEW && testRunn.getTestRunStatus() == TestRunStatus.RUNNING) {
            testRun.setTestRunStatus(TestRunStatus.RUNNING);
            addOrSaveTestRun(testRun);
        }
    }

    @Override
    public boolean inspectionAnswer(Answers answers, TestRun testRun) {
        if (answers.getAnswerList() == null)
            return false;
        for (Answer answer : answers.getAnswerList()) {
            if (testRun.getCurrentQuestion().getId() != answer.getQuestion().getId())
                return false;
            boolean b = false;
            for (Answer answerQ : testRun.getCurrentQuestion().getAnswer()) {
                if (answerQ.getId() == answer.getId()) b = true;
            }
            if (!b)
                return false;
            if (testRun.getCurrentQuestion().getAnswerType() == AnswerType.SINGLE) {
                if (answers.getIdAnswerForSingle() == answer.getId())
                    answer.setIsRight(true);
                else
                    answer.setIsRight(false);
            }
        }
        for (Answer answer : answers.getAnswerList()) {
            if (answer.getIsRight()) {
                Answer answer2 = new Answer();
                answer2.setId(answer.getId());
                resultRepository.save(new Result(testRun, testRun.getCurrentQuestion(), answer2));
            }
        }
        //реализовать проверку id вопроса и id ответа в вопросе
        //и добавить ответ в result
        return true;
    }

    @Override
    public Question hideRightAnswers(Question question) {
        if (question != null)
            for (Answer answer : question.getAnswer()) {
                answer.setIsRight(false);
            }
        return question;
    }

}
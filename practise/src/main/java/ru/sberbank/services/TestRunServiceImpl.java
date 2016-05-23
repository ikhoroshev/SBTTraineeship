package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.Question;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.TestRunStatus;
import ru.sberbank.model.UserGroup;
import ru.sberbank.repositories.TestRepository;
import ru.sberbank.repositories.TestRunRepository;

import javax.annotation.Resource;
import java.util.List;

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
    public Question getQuestion(TestRun testRun) {
        if (testRun.getTestRunStatus() == TestRunStatus.RUNNING) {
            List<Question> questionList = testRepository.findOne(testRun.getTest().getId()).getQuestions();
            int i=questionList.indexOf(testRun.getCurrentQuestion()) + 1;//если в листе нету возвратит -1,да +1=0
            if (questionList.size() == i) {
                return null;
            } else {
                Question question=questionList.get(i);
                return question;
            }
        }
        return null;
    }
}
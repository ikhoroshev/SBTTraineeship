package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.TestRun;
import ru.sberbank.repositories.TestRunRepository;

import javax.annotation.Resource;

/**
 * Created by Николай on 19.05.2016.
 */
@Service
public class TestRunServiceImpl implements TestRunService {

    @Resource
    private TestRunRepository testRunRepository;

    @Override
    public void addTestRun(TestRun testRun) {
        testRunRepository.save(testRun);
    }

    @Override
    public void deleteTestRun(Long id) {
        testRunRepository.delete(id);
    }

    @Override
    public Iterable<TestRun> getAllTestRun() {
        return testRunRepository.findAll();
    }

    @Override
    public TestRun getTestRun(Long id) {
        return testRunRepository.findOne(id);
    }

    @Override
    public Iterable<TestRun> findTestRunById(Long id) {
        return testRunRepository.findByUserIdLike(id);
    }
}

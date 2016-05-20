package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.UserGroup;
import ru.sberbank.repositories.TestRunRepository;

import javax.annotation.Resource;

/**
 * Created by Idony on 20.05.2016.
 */
@Service
public class TestRunServiceImpl implements TestRunService {
    @Resource
    TestRunRepository testRunRepository;
    @Override
    public Iterable<TestRun> findByUserGroupLike(UserGroup userGroup) {
        return testRunRepository.findByUserGroupLike(userGroup);
        
    }
}

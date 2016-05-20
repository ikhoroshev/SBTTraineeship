package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.Result;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.UserGroup;
import ru.sberbank.repositories.ResultRepository;

import javax.annotation.Resource;

/**
 * Created by Idony on 20.05.2016.
 */
@Service
public class ResultServiceImpl implements ResultService {
    @Resource
    ResultRepository resultRepository;
    @Override
    public Iterable<Result> findByTestRunUserGroupLike(UserGroup userGroup) {
        return resultRepository.findByTestRunUserGroupLike(userGroup);
    }

    @Override
    public Iterable<Result> findByTestRunLike(TestRun testRun) {
        return resultRepository.findByTestRunLike(testRun);
    }
}

package ru.sberbank.services;

import org.springframework.stereotype.Repository;
import ru.sberbank.model.Result;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.UserGroup;

/**
 * Created by Idony on 20.05.2016.
 */
public interface ResultService {
    Iterable<Result> findByTestRunUserGroupLike(UserGroup userGroup);
    Iterable<Result> findByTestRunLike(TestRun testRun);
}

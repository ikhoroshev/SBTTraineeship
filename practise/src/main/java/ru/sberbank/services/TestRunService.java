package ru.sberbank.services;

import ru.sberbank.model.TestRun;
import ru.sberbank.model.UserGroup;

/**
 * Created by Idony on 20.05.2016.
 */

public interface TestRunService {
    Iterable<TestRun> findByUserGroupIdLike(UserGroup userGroup);
}

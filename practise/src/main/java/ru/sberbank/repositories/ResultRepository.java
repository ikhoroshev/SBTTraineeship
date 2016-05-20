package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.model.Result;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.UserGroup;

/**
 * Created by Idony on 20.05.2016.
 */
@Repository
public interface ResultRepository extends CrudRepository<Result, Long> {
    Iterable<Result> findByTestRunUserGroupLike(UserGroup userGroup);
    Iterable<Result> findByTestRunLike(TestRun testRun);
}

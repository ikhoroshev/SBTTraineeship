package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.UserGroup;

/**
 * Created by Idony on 20.05.2016.
 */
@Repository
public interface TestRunRepository extends CrudRepository<TestRun, Long> {
    Iterable<TestRun> findByUserGroupLike(UserGroup userGroup);
}

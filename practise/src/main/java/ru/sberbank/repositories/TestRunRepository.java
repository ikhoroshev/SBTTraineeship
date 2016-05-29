package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.User;
import ru.sberbank.model.UserGroup;

import java.util.List;

/**
 * Created by Idony on 20.05.2016.
 */
@Repository
public interface TestRunRepository extends CrudRepository<TestRun, Long> {
    Iterable<TestRun> findByUserGroupLike(UserGroup userGroup);
    Iterable<TestRun> findByUser(User user);
    List<TestRun> findByTestIdLikeOrderByUserGroupName(Long testId);

}

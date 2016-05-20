package ru.sberbank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.TestRun;

/**
 * Created by Николай on 19.05.2016.
 */
public interface TestRunRepository extends JpaRepository<TestRun, Long> {

    Iterable<TestRun> findByUserIdLike(Long testRunUserIdLike);
}

package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.Result;

public interface ResultRepository extends CrudRepository<Result, Long> {
    Iterable<Result> findResultByUserIdAndTestRunId(Long userId, Long testRunId);
}

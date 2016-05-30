package ru.sberbank.services;

import ru.sberbank.model.Result;


public interface ResultService {

    void addResult(Result result);
    void deleteResult(Long Id);
    Iterable<Result> getAllResult();
    Result getResult(Long id);
    Iterable<Result> findResult(Long userId, Long testId);
}

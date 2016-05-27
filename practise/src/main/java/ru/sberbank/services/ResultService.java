package ru.sberbank.services;

import ru.sberbank.model.Result;

/**
 * Created by Николай on 26.05.2016.
 */
public interface ResultService {

    void addResult(Result result);
    void deleteResult(Long Id);
    Iterable<Result> getAllResult();
    Result getResult(Long id);

}

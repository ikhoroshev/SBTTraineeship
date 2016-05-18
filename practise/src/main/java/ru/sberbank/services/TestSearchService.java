package ru.sberbank.services;


import ru.sberbank.model.Test;

/**
 * Created by Илья on 18.05.2016.
 */
public interface TestSearchService {
    Iterable<Test> findTest (Test test);
}

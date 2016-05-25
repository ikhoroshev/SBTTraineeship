package ru.sberbank.services;

import ru.sberbank.model.Test;

/**
 * Created by Notebook1 on 20.05.2016.
 */
public interface TestService  {
    void addTest(Test test);

    //Iterable<Test> findTest(Test test);

    Iterable<Test> getAllTest();

    void deleteTest(Test test);
}

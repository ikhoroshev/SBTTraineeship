package ru.sberbank.services;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.Question;
import ru.sberbank.model.Test;

/**
 * Created by Notebook1 on 20.05.2016.
 */
public interface TestService  {
    void addTest(Test test);

    Iterable<Test> getAllTest();

    Test getTest(Long id);

    Iterable<Test> deleteTest(long id);
}

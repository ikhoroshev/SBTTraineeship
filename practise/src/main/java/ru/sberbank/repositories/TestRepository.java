package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.Test;

/**
 * Created by Notebook1 on 20.05.2016.
 */
public interface TestRepository extends CrudRepository<Test, Long> {
    Iterable<Test> findTestByTitle(String title);

}


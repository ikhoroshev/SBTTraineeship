package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.TestChapter;


/**
 * Created by Михаил on 19.05.2016.
 */
public interface TestChapterRepository extends CrudRepository<TestChapter, Long> {
    Iterable<TestChapter> findByTitle(String title);
}

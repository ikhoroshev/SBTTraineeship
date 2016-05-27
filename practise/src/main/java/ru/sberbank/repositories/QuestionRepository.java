package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.model.Question;
import ru.sberbank.model.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by SBT-Aleksandrov-SA on 04.04.2016.
 */
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    Set<Question> findByTestsIdLike(Long test);
}

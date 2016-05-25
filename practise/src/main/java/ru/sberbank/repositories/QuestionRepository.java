package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.model.Question;

/**
 * Created by SBT-Aleksandrov-SA on 04.04.2016.
 */
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
}

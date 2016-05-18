package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.Question;

/**
 * Created by SBT-Aleksandrov-SA on 04.04.2016.
 */
public interface QuestionRepository extends CrudRepository<Question, Long> {
    Iterable<Question> findQuestionByText(String text);
}

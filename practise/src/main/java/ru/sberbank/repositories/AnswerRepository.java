package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.model.Answer;

/**
 * Created by Idony on 25.05.2016.
 */
@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    Iterable<Answer> findByQuestionIdLike(Long questionId);
}

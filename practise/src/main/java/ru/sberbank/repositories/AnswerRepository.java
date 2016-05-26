package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.model.Answer;

import java.util.List;

/**
 * Created by Idony on 25.05.2016.
 */
@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findByQuestionIdLike(Long questionId);
}

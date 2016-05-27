package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.Answer;

/**
 * Created by Николай on 26.05.2016.
 */
public interface AnswerRepository extends CrudRepository<Answer, Long> {
}

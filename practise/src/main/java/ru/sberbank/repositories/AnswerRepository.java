package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
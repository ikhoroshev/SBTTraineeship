package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.Question;

import java.util.List;
import java.util.Set;

/**
 * Created by Idony on 27.05.2016.
 */

public interface QuestionService {
    Iterable<Question> findByTestsIdLike(Long test);
    void addQuestion (Question question);

}

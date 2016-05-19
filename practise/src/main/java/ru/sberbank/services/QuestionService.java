package ru.sberbank.services;

import ru.sberbank.model.Question;

/**
 * Created by asphodelfod on 18.05.16.
 */
public interface QuestionService {
    Iterable<Question> findQuestionByExample(Question question);
    void addQuestion(Question question);
}

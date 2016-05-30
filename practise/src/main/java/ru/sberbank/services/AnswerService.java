package ru.sberbank.services;

import ru.sberbank.model.Answer;

/**
 * Created by Николай on 26.05.2016.
 */
public interface AnswerService {

    void addAnswer(Answer answer);
    void deleteAnswer(Long id);
    Answer getAnswer(Long id);
    Iterable<Answer> getAllAnswer();
}

package ru.sberbank.services;

import ru.sberbank.model.Question;
import ru.sberbank.model.TestChapter;

public interface QuestionService {
    Iterable<Question> findQuestionByKeywordsAndTestChapter(String keywords, TestChapter testChapter);
    void addQuestion(Question question);
}

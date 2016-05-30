package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.Question;
import ru.sberbank.model.TestChapter;

/**
 * Created by SBT-Aleksandrov-SA on 04.04.2016.
 */
public interface QuestionRepository extends CrudRepository<Question, Long> {
    Iterable<Question> findQuestionByTextLike(String text);
    Iterable<Question> findQuestionByTextLikeAndTestChapterTitle(String text, String testChapterTitle);
    Question findByText(String text);
}

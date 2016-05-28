package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.Question;
import ru.sberbank.repositories.QuestionRepository;

import javax.annotation.Resource;

/**
 * Created by Idony on 27.05.2016.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    QuestionRepository questionRepository;
    @Override
    public Iterable<Question> findByTestsIdLike(Long test) {
        return questionRepository.findByTestsIdLikeOrderByTestChapterPosition(test);
    }
}

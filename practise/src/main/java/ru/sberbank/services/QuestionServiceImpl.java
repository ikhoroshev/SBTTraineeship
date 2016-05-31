package ru.sberbank.services;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ru.sberbank.model.Question;
import ru.sberbank.repositories.QuestionRepository;

/**
 * Created by dns on 19.05.16.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionRepository questionRepository;

    @Override
    public void addQuestion(Question question) {

        questionRepository.save(question);
    }

}

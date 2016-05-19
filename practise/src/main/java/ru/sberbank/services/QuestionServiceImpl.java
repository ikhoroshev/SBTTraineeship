package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.Question;
import ru.sberbank.repositories.QuestionRepository;

import javax.annotation.Resource;

/**
 * Created by asphodelfod on 18.05.16.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionRepository questionRepository;

    @Override
    public Iterable<Question> findQuestionByExample(Question question) {
        if(question.getText()!=null&&question.getText().length()>0)
            return questionRepository.findQuestionByText(question.getText());
        else return questionRepository.findAll();
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }
}

package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.Answer;
import ru.sberbank.repositories.AnswerRepository;

import javax.annotation.Resource;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Resource
    private AnswerRepository answerRepository;

    @Override
    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.delete(id);
    }

    @Override
    public Answer getAnswer(Long id) {
        return answerRepository.findOne(id);
    }

    @Override
    public Iterable<Answer> getAllAnswer() {
        return answerRepository.findAll();
    }
}

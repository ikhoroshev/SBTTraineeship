package ru.sberbank.services;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import ru.sberbank.model.Question;
import ru.sberbank.repositories.QuestionRepository;


import javax.annotation.Resource;

/**
 * Created by Idony on 27.05.2016.
=======
/**
 * Created by dns on 19.05.16.

 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource

    QuestionRepository questionRepository;
    @Override
    public Iterable<Question> findByTestsIdLike(Long test) {
        return questionRepository.findByTestsIdLikeOrderByTestChapterPosition(test);

    }
    @Override
    public void addQuestion(Question question) {

        questionRepository.save(question);
    }

}

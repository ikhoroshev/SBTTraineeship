package ru.sberbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbank.dao.QuestionRepository;
import ru.sberbank.model.Question;
import ru.sberbank.model.QuestionType;

import javax.annotation.Resource;

/**
 * Created by SBT-Aleksandrov-SA on 04.04.2016.
 */
@RestController
@EnableAutoConfiguration
@EnableJpaRepositories
public class Application {

    @Resource
    QuestionRepository questionRepository;

    @RequestMapping("/")
    String home() {
        Question question = new Question();
        question.setAnswerId(1L);
        question.setTestId(1L);
        question.setId(1L);
        question.setText("sdgfsdfsdf");
        question.setType(QuestionType.MULTIPLE);

        questionRepository.save(question);
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

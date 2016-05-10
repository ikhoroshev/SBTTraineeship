package ru.sberbank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbank.dao.QuestionRepository;
import ru.sberbank.dao.UserGroupRepository;
import ru.sberbank.dao.UserRepository;
import ru.sberbank.model.Question;
import ru.sberbank.model.QuestionType;
import ru.sberbank.model.User;
import ru.sberbank.model.UserGroup;

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
    @Resource
    UserGroupRepository userGroupRepository;
    @Resource
    UserRepository userRepository;

    @RequestMapping("/")
    String home() {
        Question question = new Question();
        question.setAnswerId(1L);
        question.setTestId(1L);
        question.setId(1L);
        question.setText("sdgfsdfsdf");
        question.setType(QuestionType.MULTIPLE);

        questionRepository.save(question);

        UserGroup userGroup = new UserGroup();
        userGroup.setId(1L);
        userGroup.setGroupName("Group 1");

        userGroupRepository.save(userGroup);

        User user = new User(userGroup, "11111", "22222", "33333");
       /* user.setId(1L);
        user.setFirstName("11111");
        user.setLastName("22222");
        user.setMiddleName("33333");
        user.setUserGroup(userGroup);*/

        userRepository.save(user);

        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

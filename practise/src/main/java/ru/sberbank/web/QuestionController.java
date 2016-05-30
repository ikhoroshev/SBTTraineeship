package ru.sberbank.web;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.repositories.QuestionRepository;
import ru.sberbank.services.QuestionService;

import ru.sberbank.model.Answer;
import ru.sberbank.model.Question;

import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.Question;
import ru.sberbank.services.QuestionService;
/**
 * Created by dns on 19.05.16.
 */
@Controller
public class QuestionController {
    @Resource
    private QuestionService questionService;

    @RequestMapping(value = "/questions/add", method = RequestMethod.GET)
    public String initAddQuestionForm (Question question, Map<String, Object> model){

        Set<Answer> answer = new LinkedHashSet<Answer>();
        answer.add(new Answer("answer 1", false));
        answer.add(new Answer("answer 2", false));
        answer.add(new Answer("answer 3", false));

        question.setAnswer(answer);
        model.put("question", question);

        return "questions/addQuestion";
    }

    @RequestMapping(value = "/questions/add", method = RequestMethod.POST)
    public String processAddTestForm (Question question){
        questionService.addQuestion(question);
        return "questions/addQuestion";
    }

}

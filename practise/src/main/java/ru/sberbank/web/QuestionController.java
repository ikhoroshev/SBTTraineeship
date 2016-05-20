package ru.sberbank.web;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
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
    public String initAddQuestionForm (Question question){
        return "questions/addQuestion";
    }

    @RequestMapping(value = "/questions/add", method = RequestMethod.POST)
    public String processAddTestForm (Question question){
        questionService.addQuestion(question);
       // return "questions/questionsList";
        return "questions/addQuestion";
    }

}

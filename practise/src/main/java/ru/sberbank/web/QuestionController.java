package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.Question;
import ru.sberbank.services.QuestionService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by asphodelfod on 18.05.16.
 */
@Controller
public class QuestionController {
    @Resource
    private QuestionService questionService;

    @RequestMapping(value = "questions/find", method = RequestMethod.GET)
    public String initViewForm(Question question){ return "questions/add-viewQuestion"; }

    @RequestMapping(value = "questions/find2", method = RequestMethod.POST)
    public String processViewForm(Question question, Map<String, Object> model){
        Iterable<Question> questions=questionService.findQuestionByExample(question);
        model.put("searchQuestion", questions);
        return "questions/add-viewQuestion";
    }

}


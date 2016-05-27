/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.web;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.Question;
import ru.sberbank.model.Test;
import ru.sberbank.repositories.QuestionRepository;
import ru.sberbank.services.TestService;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Raim
 */
@Controller
public class TestController {
  @Resource
  private TestService testService;

  @RequestMapping(value = "/tests/add", method = RequestMethod.GET)
  public String initAddTestForm (@ModelAttribute("test")Test test){
    return "tests/addTest";
  }

  @RequestMapping(value = "/tests/add", method = RequestMethod.POST)
  public String processAddTestForm (Test test){
    testService.addTest(test);
    return "tests/addTest";
  }

  @RequestMapping(value = "/tests/link", method = RequestMethod.GET)
  public String testConnectQuestionG (@ModelAttribute("test")Test test, Map<String, Object> model){
    sendQuestionsAndTests(model);
    return "tests/testLinkQuestions";
  }

  @RequestMapping(value = "/tests/link", method = RequestMethod.POST)
  public String testConnectQuestionP (Test test, Map<String, Object> model){
    sendQuestionsAndTests(model);
    return "tests/testLinkQuestions";
  }
  private void sendQuestionsAndTests(Map<String, Object> model)
  {
    Iterable<Question> questionList=testService.findAllQuestions();
    model.put("questions",questionList);
    Iterable<Test> tests=testService.findAll();
    model.put("tests",tests);
  }

}

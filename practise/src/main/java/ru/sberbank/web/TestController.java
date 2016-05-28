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
import ru.sberbank.model.CollectionFromForm;
import ru.sberbank.model.Question;
import ru.sberbank.model.Test;
import ru.sberbank.repositories.QuestionRepository;
import ru.sberbank.services.QuestionService;
import ru.sberbank.services.TestService;

import java.util.*;

/**
 *
 * @author Raim
 */
@Controller
public class TestController {
  @Resource
  private TestService testService;
  @Resource
  private QuestionService questionService;

  @RequestMapping(value = "/tests/add", method = RequestMethod.GET)
  public String initAddTestForm(@ModelAttribute("test") Test test) {
    return "tests/addTest";
  }

  @RequestMapping(value = "/tests/add", method = RequestMethod.POST)
  public String processAddTestForm(Test test) {
    testService.addTest(test);
    return "tests/addTest";
  }

  @RequestMapping(value = "/tests/link", method = RequestMethod.GET)
  public String testConnectQuestionG(@ModelAttribute("test") Test test, Map<String, Object> model) {
    Iterable<Question> questionIterable = testService.findAllQuestions();
    //добавить,чтобы проверить есть ли связь с TestRun
    Iterable<Test> tests = testService.findAll();
    model.put("tests", tests);
    test = tests.iterator().next();
    if (test != null && test.getId() != null) {
      Iterable<Question> questionIterable1 = questionService.findByTestsIdLike(test.getId());
      model.put("questionsInTest", questionIterable1);
      testService.questionsDeleteTest(test.getId(), questionIterable);
      model.put("questions", questionIterable);
    }
    return "tests/testLinkQuestions";
  }

  @RequestMapping(value = "/tests/link", method = RequestMethod.POST)
  public String testConnectQuestionP(@ModelAttribute("test") Test test,
                                     Map<String, Object> model,
                                     @ModelAttribute("collectionFromForm") CollectionFromForm collectionFromForm) {
    testService.saveQuestionsOnTest(collectionFromForm);
    Iterable<Question> questionIterable = testService.findAllQuestions();
    //добавить,чтобы проверить есть ли связь с TestRun
    Iterable<Test> tests = testService.findAll();
    model.put("tests", tests);
    if (test.getId() == null)
      test = tests.iterator().next();
    if (test != null && test.getId() != null) {
      Iterable<Question> questionIterable1 = questionService.findByTestsIdLike(test.getId());
      model.put("questionsInTest", questionIterable1);
      testService.questionsDeleteTest(test.getId(), questionIterable);
      model.put("questions", questionIterable);
    }



    return "tests/testLinkQuestions";
  }

}

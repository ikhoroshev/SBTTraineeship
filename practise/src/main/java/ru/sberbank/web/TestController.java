package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.model.Question;
import ru.sberbank.model.Test;
import ru.sberbank.services.TestService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Notebook1 on 20.05.2016.
 */
@Controller
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping(value = "test/find", method = RequestMethod.POST)
    public String initViewForm(Test test) {
        return "test/addTest";
    }

    @RequestMapping(value = "test/addTest", method = RequestMethod.POST)
    public String processViewForm(Test test, Map<String, Object> model) {
        testService.addTest(test);
        Iterable<Test> tests = testService.getAllTest();
        model.put("allTest", tests);
        return "test/testsList";
    }

    @RequestMapping(value = "test/delete/{testId}", method = RequestMethod.GET)
    public String processDeleteTestForm(Test test, @PathVariable("testId") long testId) {
        testId = Long.decode(String.valueOf(testId));
        // testService.deleteTest(id);
        Iterable<Test> testIterable = testService.deleteTest(testId);
        // model.put("allTest", testIterable);

        return "test/testsList";
    }

    @RequestMapping(value = "/tests/find", method = RequestMethod.GET)
    public String processViewQuestionForm(@ModelAttribute("test") Question test, Map<String, Object> model) {
        Iterable<Question> questionIterable = testService.findAllQuestions();
        Iterable<Question> tests = testService.findAllQuestions();
        model.put("tests", tests);
        test = tests.iterator().next();
        if (test != null && test.getId() != null) {
            Iterable<Question> questionIterable1 = testService.getAllQuestions(test.getId(), questionIterable);
            model.put("question", questionIterable);
        }
        model.put("question", questionIterable);
        return "tests/addTest";
    }
}


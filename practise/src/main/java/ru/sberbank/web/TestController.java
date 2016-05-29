package ru.sberbank.web;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.model.Question;
import ru.sberbank.model.Test;
import ru.sberbank.services.QuestionService;
import ru.sberbank.services.TestService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @Resource
    private TestService testService;

    @Resource
    private QuestionService questionService;

    @RequestMapping(value = "test/find", method = RequestMethod.GET)
    public String initAddForm(Test test) {
        return "test/addTest";
    }

    @RequestMapping(value = "test/addTest", method = RequestMethod.POST)
    public String processAddTest(Test test, Map<String, Object> model) {
        testService.addTest(test);
        Iterable<Test> tests = testService.getAllTest();
        model.put("allTest", tests);
        return "test/testsList";
    }

    @RequestMapping(value = "test/delete/{testId}", method = RequestMethod.GET)
    public String processDeleteTest(@PathVariable String testId, HashMap<String, Object> model) {
        Long id = Long.decode(testId);
        try{
            testService.deleteTest(id);
        }
        catch (DataIntegrityViolationException e){

        }
        Iterable<Test> testIterable = testService.getAllTest();
        model.put("allTest", testIterable);

        return "test/testsList";
    }

    @RequestMapping(value = "/tests/find", method = RequestMethod.GET)
    public String processViewTests(Map<String, Object> model) {
        Iterable<Test> tests = testService.getAllTest();
        model.put("allTest", tests);
        return "test/testsList";
    }
}


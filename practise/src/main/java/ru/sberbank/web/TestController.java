package ru.sberbank.web;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.model.Test;
import ru.sberbank.model.User;
import ru.sberbank.model.UserGroup;
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

    @RequestMapping(value = "test/find", method = RequestMethod.GET)
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

}

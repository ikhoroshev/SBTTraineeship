package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.User;
import ru.sberbank.services.TestRunService;
import ru.sberbank.services.TestRunServiceImpl;
import ru.sberbank.services.UserService;

import javax.annotation.Resource;

import java.util.Map;

/**
 * Created by Николай on 19.05.2016.
 */
@Controller
public class TestRunController {

    @Resource
    private UserService userService;
    @Resource
    private TestRunService testRunService;

    @RequestMapping(value = "/testRun", method = RequestMethod.GET)
    public String initTestRunForm(@RequestParam("id") Long userId, Map<String, Object> model){
        User user = userService.getUser(userId);
        model.put("user", user);
        Iterable<TestRun> testRuns = testRunService.findTestRunById(userId);
        model.put("testRuns", testRuns);
        return "testRun/testRunList";
    }
}

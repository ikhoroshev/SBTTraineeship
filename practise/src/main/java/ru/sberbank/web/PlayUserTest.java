package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sberbank.model.Test;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.TestRunStatus;
import ru.sberbank.model.User;
import ru.sberbank.services.TestRunService;
import ru.sberbank.services.TestService;
import ru.sberbank.services.UserService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Николай on 24.05.2016.
 */
@Controller
public class PlayUserTest {

    @Resource
    private UserService userService;
    @Resource
    private TestService testService;
    @Resource
    private TestRunService testRunService;

    @RequestMapping(value = "/testRun/initUserTest", method = RequestMethod.GET)
    public String initUserTest(TestRun testRun, Map<String, Object> model){

        Iterable<User> userList = userService.getAllUser();
        model.put("userList", userList);
        Iterable<Test> testList = testService.getAllTest();
        model.put("testList", testList);
        return "/testRun/initUserTest";
    }

    @RequestMapping(value = "/testRun/playUserTest", method = RequestMethod.GET)
    public String playUserTest(TestRun testRun,@RequestParam("userId") Long userId,
                               @RequestParam("testId") Long testId){

        User user = userService.getUser(userId);
        Test test = testService.getTest(testId);

        testRun.setUser(user);
        testRun.setTest(test);
        testRun.setTestRunStatus(TestRunStatus.NEW);
        testRunService.addTestRun(testRun);


        return "/testRun/userTest";
    }
}

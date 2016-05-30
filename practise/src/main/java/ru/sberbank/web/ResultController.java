package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sberbank.model.Result;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.User;
import ru.sberbank.services.ResultService;
import ru.sberbank.services.TestRunService;
import ru.sberbank.services.UserService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Кирилл on 29.05.2016.
 */
@Controller
public class ResultController {
    @Resource
    private UserService userService;
    @Resource
    private TestRunService testRunService;
    @Resource
    private ResultService resultService;

    @RequestMapping(value = "/viewResult", method = RequestMethod.GET)
    public String initResultForm(@RequestParam("userId") Long userId, @RequestParam("testRunId") Long testId, Map<String, Object> model){
        User user = userService.getUser(userId);
        TestRun test = testRunService.getTestRun(testId);
        model.put("user", user);
        model.put("test", test);

        Iterable<Result> results = resultService.findResult(userId, testId);
        model.put("result", results);
        return "result/viewResult";
    }
}

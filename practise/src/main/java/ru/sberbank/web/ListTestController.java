package ru.sberbank.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.Test;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.User;
import ru.sberbank.services.TestRunService;
import ru.sberbank.services.TestService;
import ru.sberbank.services.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Илья on 29.05.2016.
 */
@Controller
public class ListTestController {
    @Resource
    private TestRunService testRunService;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/testRun/listTests", method = RequestMethod.GET)
    public String initListTestsForm(Map<String, Object> model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByLogin(auth.getName());
        Iterable<TestRun> testRuns = testRunService.findByTestsUser(user);
//        for (TestRun testr: testRuns) {
//            testr.getTest().getTitle();
//        }
        model.put("searchResult", testRuns);
        model.put("isError", "");
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "testRun/listTests";
    }


}

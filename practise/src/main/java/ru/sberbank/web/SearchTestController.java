package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.Test;
import ru.sberbank.model.User;
import ru.sberbank.services.TestService;


import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Илья on 17.05.2016.
 */
@Controller
public class SearchTestController {
    @Resource
    private TestService testService;

    @RequestMapping(value = "/tests/search", method = RequestMethod.GET)
    public String initSearchTestForm (Test test){
        return "tests/searchTest";
    }

//    @RequestMapping(value = "/users/find", method = RequestMethod.POST)
//    public String initSearchForm(User user) {
//        return "users/usersList";
//    }

    @RequestMapping(value = "/tests/search", method = RequestMethod.POST)
    public String processAddTestForm (Test test, Map<String, Object> model) {
        Iterable<Test> tests = testService.findTest(test);
        model.put("searchResult", tests);
        return "tests/searchTest";
    }

}
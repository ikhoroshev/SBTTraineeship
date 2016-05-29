package ru.sberbank.web;

import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.*;
import ru.sberbank.services.TestService;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Controller
public class SearchTestController {
    @Resource
    private TestService testService;

    @RequestMapping(value = "/tests/search", method = RequestMethod.GET)
    public String initSearchTestForm(Test test) {
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "tests/searchTest";
    }


    @RequestMapping(value = "/tests/search", method = RequestMethod.POST)
    public String processSearchForm(Test test, Map<String, Object> model) {
        Iterable<Test> tests = testService.findTest(test);
        model.put("searchResult", tests);
        model.put("isError", "");
        return "tests/searchTest";
    }

    @RequestMapping(value = "/tests/search/dellete", method = RequestMethod.GET)
    public String dellete(Test test, Map<String, Object> model) {
        Iterable<Test> tests = testService.findAll();
        model.put("searchResult", tests);
        model.put("isError", "");;
        return "tests/searchTest";
    }

    @RequestMapping(value = "/tests/delete/{testID}", method = RequestMethod.GET)
    public String getTest(@PathVariable String testID, Test test, HashMap<String, Object> model) {
        Long id = Long.decode(testID);
        model.put("isError", testService.deleteTest(id) );

        Iterable<Test> tests = testService.findTest(test);
        model.put("searchResult", tests);

        return "tests/searchTest";
    }
}
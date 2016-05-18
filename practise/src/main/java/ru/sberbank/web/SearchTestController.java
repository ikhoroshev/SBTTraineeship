package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.Test;
import ru.sberbank.services.TestSearchService;
import ru.sberbank.services.TestService;


import javax.annotation.Resource;

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

    @RequestMapping(value = "/tests/search", method = RequestMethod.POST)
    public String processAddTestForm (Test test){
        testService.findTest(test);
        return "tests/testsList";
    }

}
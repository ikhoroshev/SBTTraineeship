package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "test/add", method = RequestMethod.GET)
    public String initViewForm(Test test){ return "test/addTest"; }

    @RequestMapping(value = "test/add", method = RequestMethod.POST)
    public String processViewForm(Test test){
        testService.addTest(test);
        return "test/addTest";
    }
}

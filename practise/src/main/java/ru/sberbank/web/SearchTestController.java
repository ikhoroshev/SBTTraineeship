package ru.sberbank.web;

import org.springframework.http.HttpRequest;
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

/**
 * Created by Илья on 17.05.2016.
 */
@Controller
public class SearchTestController {
    @Resource
    private TestService testService;

    @RequestMapping(value = "/tests/search", method = RequestMethod.GET)
    public String initSearchTestForm(Test test) {
        return "tests/searchTest";
    }

    @RequestMapping(value = "/tests/search/dellete", method = RequestMethod.GET)
    public String initSearchTestFormForRemoveTest(Test test, Map<String, Object> model) {
        Iterable<Test> tests = testService.findTest(test);
        model.put("searchResult", tests);
        model.put("isError", "");
        return "tests/searchTest";
    }


    @RequestMapping(value = "/tests/search", method = RequestMethod.POST)
    public String processAddTestForm(Test test, Map<String, Object> model) {
        Iterable<Test> tests = testService.findTest(test);
        model.put("searchResult", tests);
        model.put("isError", "");
        return "tests/searchTest";
    }

//    @RequestMapping(value = "/tests/del", method = RequestMethod.POST)
//    public String dellete(@ModelAttribute("TestForm") TestForm testForm) {
//        System.out.println("111");
//        return "tests/searchTest";
//    }

    @RequestMapping(value = "/tests/delete/{testID}", method = RequestMethod.GET)
    public String getTest(@PathVariable String testID, Test test, HashMap<String, Object> model) {
        Long id = Long.decode(testID);
        model.put("isError", testService.deleteTest(id) );

        Iterable<Test> tests = testService.findTest(test);
        model.put("searchResult", tests);

        //questionService.deleteQuestion(id);

       // question = tempQuestion;

//        Iterable<Question> questions = questionService.findQuestionByKeywordsAndTestChapter(question.getText(), question.getTestChapter());
//        model.put("searchQuestion", questions);
//        Iterable<TestChapter> allTestChapter = testChapterService.getAllTestChapter();
//        model.put("allTestChapter", allTestChapter);
        return "tests/searchTest";
    }
}
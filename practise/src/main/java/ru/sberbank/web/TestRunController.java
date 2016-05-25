package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.Answer;
import ru.sberbank.model.Answers;
import ru.sberbank.model.Question;
import ru.sberbank.model.TestRun;
import ru.sberbank.services.TestRunService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Idony on 23.05.2016.
 */
@Controller
public class TestRunController {
    @Resource
    TestRunService testRunService;

    @RequestMapping(value = "/testRun/{testRunId}", method = RequestMethod.GET)
    public String processGetForm(Map<String, Object> objectMap,
                                 @PathVariable("testRunId") long testRunId,
                                 Model model,
                                 @ModelAttribute("testRun") TestRun testRun,
                                 @ModelAttribute("answers") Answers answer) {



        objectMap.put("testRunId", testRunId);

        Question question = testRunService.nextQuestion(testRunId, testRun, answer);
        objectMap.put("question", question);
        objectMap.put("testRun", testRunService.findOne(testRunId));
        return "/testRun/testRun";
    }

    @RequestMapping(value = "/testRun/{testRunId}", method = RequestMethod.POST)
    public String processPostForm(Map<String, Object> objectMap,
                                  @PathVariable("testRunId") long testRunId,
                                  Model model,
                                  @ModelAttribute("testRun") TestRun testRun,
                                  @ModelAttribute("answers") Answers answer) {
        testRunService.startTest(testRunId,testRun);
        Question question = testRunService.nextQuestion(testRunId, testRun, answer);
        objectMap.put("question", question);
        objectMap.put("testRun", testRunService.findOne(testRunId));
        return "/testRun/testRun";
    }
}

package ru.sberbank.web;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.Question;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.TestRunStatus;
import ru.sberbank.services.TestRunService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Idony on 23.05.2016.
 */
@Controller
public class TestRunController {
    @Resource
    TestRunService testRunService;

    @RequestMapping(value = "/testRun/{testRunId}", method = RequestMethod.GET)
    public String processGetForm(Map<String, Object> objectMap, @PathVariable("testRunId") long userId, Model model, @ModelAttribute("testRun") TestRun testRun) {
        TestRun testRun1 = testRunService.findOne(userId);

        objectMap.put("testRun", testRun1);
        objectMap.put("testRunId", userId);
        if (testRun1 != null) {
            Question question = testRunService.getQuestion(testRun1);
            if (question == null) {
                testRun1.setTestRunStatus(TestRunStatus.COMPLETED);
                testRunService.addOrSaveTestRun(testRun1);
                return "/testRun/testRun";
            }
            objectMap.put("question", question);
        }
        return "/testRun/testRun";
    }

    @RequestMapping(value = "/testRun/{testRunId}", method = RequestMethod.POST)
    public String processPostForm(Map<String, Object> objectMap,
                                  @PathVariable("testRunId") long userId, Model model,
                                  @ModelAttribute("testRun") TestRun testRun) {
        TestRun testRun2 = testRunService.findOne(userId);
        if (testRun != null) {
            if (testRun2.getTestRunStatus() == TestRunStatus.NEW) {
                testRun2.setTestRunStatus(TestRunStatus.RUNNING);
                testRunService.addOrSaveTestRun(testRun2);
            }

            //if()получен answer и id вопроса совпадает с текущим у TestRun хранить answer и на jsp новый вопрос
            Question question = testRunService.getQuestion(testRun2);
            if (question == null) {
                testRun2.setTestRunStatus(TestRunStatus.COMPLETED);
                testRunService.addOrSaveTestRun(testRun2);
                return "/testRun/testRun";
            }
            testRun.setCurrentQuestion(question);
            testRunService.addOrSaveTestRun(testRun);
            objectMap.put("question", question);
        }

        return "/testRun/testRun";
    }
}

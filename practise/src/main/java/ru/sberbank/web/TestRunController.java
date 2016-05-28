package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.*;
import ru.sberbank.repositories.AnswerRepository;
import ru.sberbank.repositories.UserRepository;
import ru.sberbank.services.TestRunService;
import ru.sberbank.services.TestService;
import ru.sberbank.services.UserService;

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
    @Resource
    private TestService testService;
    @Resource
    private UserService userService;

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
        objectMap.put("question", testRunService.hideRightAnswers(question));
        objectMap.put("testRun", testRunService.findOne(testRunId));

        return "/testRun/testRun";
    }



    @RequestMapping(value = "/testRun/link", method = RequestMethod.GET)
    public String testConnectQuestionG(@ModelAttribute("test") Test test, Map<String, Object> model) {

        Iterable<Test> tests = testService.findAllHaventLine();
        model.put("tests", tests);

        List<User> users = userService.findAllByOrderByGroupName();

        if (test.getId() == null)
        test = tests.iterator().next();

        if (test != null && test.getId() != null) {
            List<User> users2=testService.deleteUserLineTest(test.getId(), users);
            model.put("usersTest", users2);
        }
        model.put("users", users);

        return "testRun/lineTestWithUser";
    }

    @RequestMapping(value = "/testRun/link", method = RequestMethod.POST)
    public String testConnectQuestionP(@ModelAttribute("test") Test test,
                                       Map<String, Object> model,
                                       @ModelAttribute("collectionFromForm") CollectionFromForm collectionFromForm) {

        testService.saveUserLineTest(collectionFromForm);
        Iterable<Test> tests = testService.findAllHaventLine();
        model.put("tests", tests);



        List<User> users = userService.findAllByOrderByGroupName();

        if (test.getId() == null)
            test = tests.iterator().next();

        if (test != null && test.getId() != null) {
            List<User> users2=testService.deleteUserLineTest(test.getId(), users);
            model.put("usersTest", users2);
        }
        model.put("users", users);

        return "testRun/lineTestWithUser";
    }
}

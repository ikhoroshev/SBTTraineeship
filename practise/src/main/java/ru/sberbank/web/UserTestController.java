package ru.sberbank.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.components.UserTestRun;
import ru.sberbank.model.*;
import ru.sberbank.repositories.ResultRepository;
import ru.sberbank.services.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Николай on 26.05.2016.
 */
@Controller
@SessionAttributes(types = UserTestRun.class)
public class UserTestController {

    @Resource
    private TestRunService testRunService;
    @Resource
    private QuestionService questionService;
    @Resource
    private AnswerService answerService;
    @Resource
    private ResultService resultService;

    @RequestMapping(value = "/userTest/start", method = RequestMethod.GET)
    public String initUserTest(UserTestRun userTestRun,
                               @RequestParam("testRunId")Long testRunId,
                               Map<String, Object> model){

        TestRun testRun = testRunService.getTestRun(testRunId);
        Test test = testRun.getTest();
        User user = testRun.getUser();

        //////временно/////////////////////////////
        List<Question> questionList = (List<Question>) questionService.getAllQuestion();
        test.setQuestions(questionList);
        ///////////////////////////////////////////////////////////////////////////

        userTestRun.setTestRun(testRun);
        userTestRun.setTest(test);
        userTestRun.setUser(user);
        userTestRun.init();
        model.put("test", test);
        return "userTest/initUserTest";
    }

    @RequestMapping(value = "/userTest/next", method = RequestMethod.GET)
    public String nextQuestion(UserTestRun userTestRun, Question question,
                               @RequestParam("id")List<Long> ids, Map<String, Object> model){

            for (Long id: ids) {
                Result result = new Result();
                Answer answer = answerService.getAnswer(id);
                result.setUser(userTestRun.getUser());
                result.setTestRun(userTestRun.getTestRun());
                result.setQuestion(userTestRun.getQuestion());
                result.setAnswer(answer);
                resultService.addResult(result);
            }

        question = userTestRun.nextQuestions();
        if (question == null){
            return "userTest/stopUserTest";
        }
        model.put("type", question.getType().ordinal());
        model.put("question", question);
        model.put("answers", question.getAnswers());
        return "userTest/nextQuestion";


    }
}

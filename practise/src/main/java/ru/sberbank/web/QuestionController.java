package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.Answer;
import ru.sberbank.model.Question;
import ru.sberbank.model.QuestionType;
import ru.sberbank.model.TestChapter;
import ru.sberbank.services.QuestionService;
import ru.sberbank.services.TestChapterService;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by asphodelfod on 18.05.16.
 */
@Controller
public class QuestionController {
    @Resource
    private QuestionService questionService;

    @Resource
    private TestChapterService testChapterService;

    @RequestMapping(value = "questions/find", method = RequestMethod.GET)
    public String initViewForm(Question question, Map<String, Object> model){
        Iterable<TestChapter> allTestChapter = testChapterService.getAllTestChapter();
        model.put("allTestChapter", allTestChapter);
        return "questions/add-viewQuestion";
    }

    @RequestMapping(value = "questions/find", method = RequestMethod.POST)
    public String processAddForm(Question question, Map<String, Object> model){
        Iterable<TestChapter> testChapterByTitle = testChapterService.getTestChapterByTitle(question.getTestChapter().getTitle());
        question.setTestChapter(testChapterByTitle.iterator().next());
        List<Answer> answers = question.getAnswers();
        Iterator<Answer> it=answers.iterator();
        while(it.hasNext()){
            Answer answer=it.next();
            if(answer.getText()==null||answer.getText().trim().length()==0)
                it.remove();
            else
                answer.setQuestion(question);
        }

        questionService.addQuestion(question);

        question.setText(null);
        question.setTestChapter(null);
        Iterable<TestChapter> allTestChapter = testChapterService.getAllTestChapter();
        model.put("allTestChapter", allTestChapter);
        return "questions/add-viewQuestion";
    }


    @RequestMapping(value = "questions/find2", method = RequestMethod.POST)
    public String processViewForm(Question question, Map<String, Object> model){
        Iterable<Question> questions=questionService.findQuestionByKeywordsAndTestChapter(question.getText(), question.getTestChapter());
        model.put("searchQuestion", questions);
        Iterable<TestChapter> allTestChapter = testChapterService.getAllTestChapter();
        model.put("allTestChapter", allTestChapter);
        return "questions/add-viewQuestion";
    }

    @RequestMapping(value = "questions/add", method = RequestMethod.GET)
    public String initAddForm(Question question, Map<String, Object> model){
        Iterable<TestChapter> allTestChapter = testChapterService.getAllTestChapter();
        model.put("allTestChapter", allTestChapter);
        model.put("QuestionType", QuestionType.values());
        return "questions/addQuestion";
    }

}


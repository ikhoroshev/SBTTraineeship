package ru.sberbank.web;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.*;
import ru.sberbank.services.QuestionService;
import ru.sberbank.services.SystemLogService;
import ru.sberbank.services.TestChapterService;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class QuestionController {
    private Question tempQuestion;

    @Resource
    private QuestionService questionService;

    @Resource
    private TestChapterService testChapterService;

    @Resource
    private SystemLogService log;

    @RequestMapping(value = "/questions/find", method = RequestMethod.GET)
    public String initViewForm(Question question, Map<String, Object> model){
        Iterable<TestChapter> allTestChapter = testChapterService.getAllTestChapter();
        model.put("allTestChapter", allTestChapter);
        return "questions/add-viewQuestion";
    }

    @RequestMapping(value = "/questions/find", method = RequestMethod.POST)
    public String processAddForm(Question question, Map<String, Object> model){
        model.put("question",question);
        Iterable<TestChapter> allTestChapter = testChapterService.getAllTestChapter();
        model.put("allTestChapter", allTestChapter);

        //валидация//////////////////////////////////////////////
        int answerCount=0;
        int rightCount=0;
        for (Answer answer : question.getAnswers())
            if(answer.getText().trim().length()>0) {
                answerCount++;
                if(answer.getIsRight())
                    rightCount++;
            }
        if(question.getText().trim().length()==0||question.getText().trim().length()>2000){
            model.put("questionError",new String("В вопросе должно быть больше 0 и меньше 2000 символов!"));
            return "questions/addQuestion";
        }
        if(question.getTestChapter()==null){
            model.put("chapterError",new String("Создайте хотя бы одну главу для вопросов!"));
            return "questions/addQuestion";
        }
        if(answerCount<2){
            model.put("answerError",new String("Вопрос должен иметь по крайней мере 2 ответа!"));
            return "questions/addQuestion";
        }
        if(rightCount==0){
            model.put("rightError",new String("Отметьте по крайней мере один правильный ответ!"));
            return "questions/addQuestion";
        }

        //заполнение недостающих полей в question
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
        if(rightCount>1)
            question.setType(QuestionType.MULTIPLE);
        else question.setType(QuestionType.SINGLE);

        questionService.addQuestion(question);
        log.Log(10,question.getText());

        question.setText(null);
        question.setTestChapter(null);
        return "questions/add-viewQuestion";
    }


    @RequestMapping(value = "/questions/find2", method = RequestMethod.POST)
    public String processViewForm(Question question, Map<String, Object> model){
        Iterable<Question> questions;
        if(question.getTestChapter().getTitle().compareTo("ALL")==0)
            questions=questionService.findQuestionByKeywordsAndTestChapter(question.getText(),null);
        else questions=questionService.findQuestionByKeywordsAndTestChapter(question.getText(), question.getTestChapter());

        model.put("searchQuestion", questions);
        Iterable<TestChapter> allTestChapter = testChapterService.getAllTestChapter();
        model.put("allTestChapter", allTestChapter);
        tempQuestion=new Question();
        tempQuestion.setText(question.getText());
        tempQuestion.setTestChapter(question.getTestChapter());
        return "questions/add-viewQuestion";
    }

    @RequestMapping(value = "/questions/add", method = RequestMethod.GET)
    public String initAddForm(Question question, Map<String, Object> model){
        Iterable<TestChapter> allTestChapter = testChapterService.getAllTestChapter();
        model.put("allTestChapter", allTestChapter);
        model.put("QuestionType", QuestionType.values());
//        model.put("isEdit", false);
        return "questions/addQuestion";
    }

    @RequestMapping(value = "/questions/delete/{questionID}", method = RequestMethod.GET)
    public String processDeleteQuestion(@PathVariable String questionID, Question question, Map<String, Object> model){
        Long id = Long.decode(questionID);
        try {
            questionService.deleteQuestion(id);
            log.Log(12,"id="+id);
        }
        catch (DataIntegrityViolationException e){
            log.Log("Исключение при удалении вопроса с id="+id+" <"+e+">",110);
            Iterable<SystemLog> systemLogs = log.findAll();
            model.put("systemLogs", systemLogs);
            return "log/viewLog";
        }

        question=tempQuestion;
        Iterable<Question> questions;
        if(question.getTestChapter().getTitle().compareTo("ALL")==0)
            questions=questionService.findQuestionByKeywordsAndTestChapter(question.getText(), null);
        else questions=questionService.findQuestionByKeywordsAndTestChapter(question.getText(), question.getTestChapter());

        model.put("searchQuestion", questions);
        Iterable<TestChapter> allTestChapter = testChapterService.getAllTestChapter();
        model.put("allTestChapter", allTestChapter);
        return "questions/add-viewQuestion";

    }

    @RequestMapping(value = "/questions/edit/{questionID}", method = RequestMethod.GET)
    public String processEditQuestion(@PathVariable String questionID, Map<String, Object> model){
        Long id = Long.decode(questionID);

        Iterable<TestChapter> allTestChapter = testChapterService.getAllTestChapter();
        model.put("allTestChapter", allTestChapter);
//        model.put("QuestionType", QuestionType.values());

        Question editQuestion = questionService.findQuestionByID(id);
        model.put("question", editQuestion);
//        model.put("isEdit", true);

//        questionService.deleteQuestion(editQuestion.getId());

        return "/questions/addQuestion";
    }
}


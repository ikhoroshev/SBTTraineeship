package ru.sberbank.web;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.TestChapter;
import ru.sberbank.model.User;
import ru.sberbank.services.SystemLogService;
import ru.sberbank.services.TestChapterService;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class TestChapterController {
    @Resource
    private TestChapterService testChapterService;

    @Resource
    private SystemLogService log;

    @RequestMapping(value = "chapters/find", method = RequestMethod.GET)
    public String initViewForm(TestChapter testChapter){ return "chapters/addTestChapter"; }


    @RequestMapping(value = "/chapters/addTestChapter", method = RequestMethod.POST)
    public String processAddTestChapterForm (TestChapter testChapter,Map<String, Object> model){

        if (testChapter.getPosition()==null)
            testChapter.setPosition(0);
        testChapterService.addTestChapter(testChapter);
        log.Log(13);
        Iterable<TestChapter> testChaptersIterable = testChapterService.getAllTestChapter();
        model.put("allTestChapter", testChaptersIterable);
        return "chapters/testChapterList";
    }

    @RequestMapping(value = "/chapters/testChapterList", method = RequestMethod.GET)
    public String processViewTestChapterForm (TestChapter testChapter, Map<String, Object> model){

        Iterable<TestChapter> testChaptersIterable = testChapterService.getAllTestChapter();
        model.put("allTestChapter", testChaptersIterable);
        return "chapters/testChapterList";
    }
    @RequestMapping(value = "testChapter/delete/{testChapterId}", method = RequestMethod.GET)
    public String processDeleteTestChapterForm (TestChapter testChapter, @PathVariable String testChapterId,Map<String, Object> model){

        Long id = Long.decode(testChapterId);
        try {
            testChapterService.deleteTestChapter(id);
            log.Log(15);
        }catch (DataIntegrityViolationException e){
            log.Log(String.valueOf(e),100);
            Iterable<TestChapter> testChapterIterable = testChapterService.getAllTestChapter();
            model.put("allTestChapter", testChapterIterable);
            model.put("noDelete", "- can not be removed");
            model.put("testChapterId", testChapterId);
            return "chapters/testChapterList";
        }
        Iterable<TestChapter> testChaptersIterable = testChapterService.getAllTestChapter();
        model.put("allTestChapter", testChaptersIterable);

        return "chapters/testChapterList";
    }
    @RequestMapping(value = "testChapter/edit/{testChapterId}", method = RequestMethod.GET)
    public String processEditTestChapter(@PathVariable String testChapterId, Map<String, Object> model){
        Long id = Long.decode(testChapterId);
        log.Log(14);
        TestChapter editTestChapter = testChapterService.findTestChapterByID(id);
        model.put("testChapter", editTestChapter);

        return "/chapters/addTestChapter";
    }
}

package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.TestChapter;
import ru.sberbank.model.User;
import ru.sberbank.services.TestChapterService;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class TestChapterController {
    @Resource
    private TestChapterService testChapterService;


    @RequestMapping(value = "chapters/find", method = RequestMethod.GET)
    public String initViewForm(TestChapter testChapter){ return "chapters/addTestChapter"; }


    @RequestMapping(value = "/chapters/addTestChapter", method = RequestMethod.POST)
    public String processAddTestChapterForm (TestChapter testChapter){

        if (testChapter.getPosition()==null)
            testChapter.setPosition(0);
        testChapterService.addTestChapter(testChapter);
        return "chapters/addTestChapter";
    }

    @RequestMapping(value = "/chapters/testChapterList", method = RequestMethod.GET)
    public String processViewTestChapterForm (TestChapter testChapter, Map<String, Object> model){

        Iterable<TestChapter> testChaptersIterable = testChapterService.getAllTestChapter();
        model.put("allTestChapter", testChaptersIterable);
        return "chapters/testChapterList";
    }
    @RequestMapping(value = "testChapter/{testChapterId}", method = RequestMethod.GET)
    public String processDeleteTestChapterForm (TestChapter testChapter, @PathVariable("testChapterId") long testChapterId){
        testChapterService.deleteTestChapter(testChapterId);
        return "chapters/testChapterList";
    }


}

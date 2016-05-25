package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.TestChapter;
import ru.sberbank.repositories.TestChapterRepository;
import ru.sberbank.repositories.UserGroupRepository;

import javax.annotation.Resource;

/**
 * Created by Михаил on 19.05.2016.
 */
@Service
public class TestChapterServiceImpl implements TestChapterService {
    @Resource
    private TestChapterRepository testChapterRepository;

    @Override
    public void addTestChapter(TestChapter testChapter) {
        testChapterRepository.save(testChapter);
    }

    @Override
    public Iterable<TestChapter> getAllTestChapter() {
        return testChapterRepository.findAll();
    }

    @Override
    public Iterable<TestChapter> getTestChapterByTitle(String title) { return testChapterRepository.findByTitle(title); }

    @Override
    public void deleteTestChapter(Long id) {
        testChapterRepository.delete(id);
    }

    @Override
    public TestChapter findTestChapterByID(Long id) {
        return testChapterRepository.findOne(id);
    }
}




package ru.sberbank.services;


import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.google.common.base.Strings;
import ru.sberbank.model.Test;
import ru.sberbank.repositories.TestRepository;


/**
 * Created by Notebook1 on 20.05.2016.
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestRepository testRepository;

    @Override
    public void addTest(Test test) {
        testRepository.save(test);
    }

    @Override
    public Iterable<Test> getAllTest() {
        return testRepository.findAll();
    }
}







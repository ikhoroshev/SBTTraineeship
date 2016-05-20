package ru.sberbank.services;

import com.google.common.base.Strings;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


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
}







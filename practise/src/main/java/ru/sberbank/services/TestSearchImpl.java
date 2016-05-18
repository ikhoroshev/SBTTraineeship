package ru.sberbank.services;

import com.google.common.base.Strings;
import ru.sberbank.model.Test;
import ru.sberbank.repositories.TestRepository;

/**
 * Created by Илья on 18.05.2016.
 */
public class TestSearchImpl implements TestSearchService {
    private TestRepository testRepository;

    @Override
    public Iterable<Test> findTest (Test test) {
        if (!Strings.isNullOrEmpty(test.getDescription())
                && !Strings.isNullOrEmpty(test.getTitle())) {
            return testRepository.findByTitleLike('%' + test.getTitle() +  '%');
        }
        return null;
    }
}

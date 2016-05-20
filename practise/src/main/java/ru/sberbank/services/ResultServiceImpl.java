package ru.sberbank.services;


import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import ru.sberbank.model.Result;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.UserGroup;
import ru.sberbank.repositories.ResultRepository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Idony on 20.05.2016.
 */
@Service
public class ResultServiceImpl implements ResultService {
    @Resource
    ResultRepository resultRepository;
    Iterable<TestRun> testRuns;
    int n,k;
    @Resource
    private TestRunService testRunService;
    @Override
    public Iterable<Result> findByTestRunUserGroupLike(UserGroup userGroup) {
        return resultRepository.findByTestRunUserGroupLike(userGroup);
    }

    @Override
    public Iterable<Result> findByTestRunLike(TestRun testRun) {
        return resultRepository.findByTestRunLike(testRun);
    }
    List<Pair<TestRun,Float>> pairList;
    public List<Pair<TestRun, Float>> resultByGroup(UserGroup userGroup)
    {
        pairList=new ArrayList<>();
        testRuns=testRunService.findByUserGroupLike(userGroup);
        for (TestRun testRun:testRuns)
        {
            for (Result result:findByTestRunLike(testRun))
            {
                if(result.getAnswer().getIsRight())n++;
                else k++;
            }
            pairList.add(Pair.of(testRun,(float)n / (n + k) ));
            n=0;k=0;
        }//n/(n+k) % правильных
        return pairList;
    }
}

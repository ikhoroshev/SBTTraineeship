package ru.sberbank.services;


import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import ru.sberbank.model.*;
import ru.sberbank.repositories.ResultRepository;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Idony on 20.05.2016.
 */
@Service
public class ResultServiceImpl implements ResultService {
    @Resource
    ResultRepository resultRepository;

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

    public List<Pair<TestRun, Float>> resultByGroup(UserGroup userGroup)
    {
        Iterable<TestRun> testRuns=testRunService.findByUserGroupLike(userGroup);
        int n=0;
        int k=0;
        List<Pair<TestRun,Float>> pairList=new ArrayList<>();
        HashMap<Question,Boolean> hashMapQuestionAndResult=null;
        Boolean b;
        for (TestRun testRun:testRuns)
        {
            if(testRun.getTestRunStatus() == TestRunStatus.COMPLETED) {
                if (hashMapQuestionAndResult == null) {
                    hashMapQuestionAndResult = new HashMap<>();
                } else {
                    hashMapQuestionAndResult.clear();
                }

                for (Result result : findByTestRunLike(testRun)) {
                    b = hashMapQuestionAndResult.get(result);
                    if (b == null || b)
                        hashMapQuestionAndResult.put(result.getQuestion(), result.getAnswer().getIsRight());
                }

                for (Boolean value : hashMapQuestionAndResult.values()) {
                    n++;
                    if (value) k++;
                }

                pairList.add(Pair.of(testRun, (float) k / n));
                n = 0;
                k = 0;
            }
        }//n/(n+k) % правильных
        return pairList;
    }
}

package ru.sberbank.services;


import org.hibernate.Hibernate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import ru.sberbank.model.*;
import ru.sberbank.repositories.AnswerRepository;
import ru.sberbank.repositories.QuestionRepository;
import ru.sberbank.repositories.ResultRepository;
import ru.sberbank.repositories.TestRepository;

import javax.annotation.Resource;
import java.util.ArrayList;

import java.lang.Iterable;
import java.util.List;
import java.util.Set;


/**
 * Created by Idony on 20.05.2016.
 */
@Service
public class ResultServiceImpl implements ResultService {
    @Resource
    ResultRepository resultRepository;

    @Resource
    private TestRunService testRunService;

    @Resource
    private QuestionRepository questionRepository;

    @Resource
    private AnswerRepository answerRepository;


    @Override
    @Transient
    public List<Pair<TestRun, Float>> resultByGroup(UserGroup userGroup) {
        if(userGroup.getId()==null)return null;
        Iterable<TestRun> testRuns = testRunService.findByUserGroupLike(userGroup);
        int n = 0;
        int k = 0;
        List<Pair<TestRun, Float>> pairList = new ArrayList<>();

        Boolean b;
        for (TestRun testRun : testRuns) {
            if (testRun.getTestRunStatus() == TestRunStatus.COMPLETED) {
                for (Question question : questionRepository.findByTestsIdLike(testRun.getTest().getId())) {
                    n++;
                    List<Result> results = resultRepository.findByTestRunIdLikeAndQuestionId(testRun.getId(), question.getId());
                    if (question.getAnswerType() == AnswerType.SINGLE) {
                        if (results.iterator().next().getAnswer().getIsRight()) k++;
                    } else if (question.getAnswerType() == AnswerType.MULTIPLE) {
                        if(answerRepository.findByQuestionIdLike(question.getId()).size()!=results.size())
                            continue;
                        for(Result result:results)
                        {
                            if(!result.getAnswer().getIsRight())
                                continue;
                        }
                        k++;
                    }

                }
                pairList.add(Pair.of(testRun, (float) k / n));
                n = 0;
                k = 0;
            }
        }
        return pairList;
    }
}

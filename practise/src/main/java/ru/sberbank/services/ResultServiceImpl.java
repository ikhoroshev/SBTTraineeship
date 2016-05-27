package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.Result;
import ru.sberbank.repositories.ResultRepository;

import javax.annotation.Resource;

/**
 * Created by Николай on 26.05.2016.
 */
@Service
public class ResultServiceImpl implements ResultService {

    @Resource
    private ResultRepository resultRepository;

    @Override
    public void addResult(Result result) {
        resultRepository.save(result);
    }

    @Override
    public void deleteResult(Long id) {
        resultRepository.delete(id);
    }

    @Override
    public Iterable<Result> getAllResult() {
        return resultRepository.findAll();
    }

    @Override
    public Result getResult(Long id) {
        return resultRepository.findOne(id);
    }
}

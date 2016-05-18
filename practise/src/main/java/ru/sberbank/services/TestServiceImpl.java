/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.services;

import javax.annotation.Resource;

import com.google.common.base.Strings;
import org.springframework.stereotype.Service;
import ru.sberbank.model.Test;
import ru.sberbank.repositories.TestRepository;

/**
 *
 * @author Raim
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
  public Iterable<Test> findTest (Test test) {
    if (!Strings.isNullOrEmpty(test.getDescription())
            && !Strings.isNullOrEmpty(test.getTitle())) {
      return testRepository.findByTitleLike('%' + test.getTitle() +  '%');
    }
    return testRepository.findAll();
  }
  
}

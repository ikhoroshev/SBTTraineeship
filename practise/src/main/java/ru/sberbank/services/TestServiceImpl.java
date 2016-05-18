/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.services;

import javax.annotation.Resource;
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
  
}

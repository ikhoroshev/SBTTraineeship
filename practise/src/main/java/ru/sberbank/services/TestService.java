/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.services;

import ru.sberbank.model.Test;
import ru.sberbank.model.User;

/**
 *
 * @author Raim
 */
public interface TestService {
  void addTest (Test test);
  String deleteTest(Long id);
  Iterable<Test> findTest (Test test);
//  Iterable<Test> findAllTestsUser (User user);
}

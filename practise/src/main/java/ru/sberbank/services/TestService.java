/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.services;

import ru.sberbank.model.CollectionFromForm;
import ru.sberbank.model.Question;
import ru.sberbank.model.Test;
import ru.sberbank.model.User;

import java.util.List;

/**
 *
 * @author Raim
 */
public interface TestService {
  void addTest (Test test);
  String deleteTest(Long id);
  Iterable<Test> findTest (Test test);
  Iterable<Question> findAllQuestions();
  Iterable<Test> findAll();
  Test findOne(Long id);
  Iterable<Question> deleteQuestionsInTest(Long idTest, Iterable<Question> questionIterable);
  List<User> deleteUserLineTest(Long idTest, List<User> questionIterable);
  void saveQuestionsOnTest(CollectionFromForm collectionFromForm);
  Iterable<Test> findAllHaventLine();

  void saveUserLineTest(CollectionFromForm collectionFromForm);
}

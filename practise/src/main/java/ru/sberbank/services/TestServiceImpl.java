/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.services;

import javax.annotation.Resource;

import com.google.common.base.Strings;
import org.springframework.stereotype.Service;
import ru.sberbank.model.*;
import ru.sberbank.repositories.QuestionRepository;
import ru.sberbank.repositories.TestRepository;
import ru.sberbank.repositories.TestRunRepository;

import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Raim
 */
@Service
public class TestServiceImpl implements TestService {
  @Resource
  private TestRepository testRepository;
  @Resource
  private QuestionRepository questionRepository;
  @Resource
  private QuestionService questionService;
  @Resource
  private TestRunRepository testRunRepository;

  @Override
  public void addTest(Test test) {
    testRepository.save(test);
  }

  @Override
  public Iterable<Test> findTest(Test test) {
    if (!Strings.isNullOrEmpty(test.getDescription())
            && !Strings.isNullOrEmpty(test.getTitle())) {
      return testRepository.findByTitleLikeAndDescriptionLike('%' + test.getTitle() + '%', '%' + test.getDescription() + '%');
    }
    if (!Strings.isNullOrEmpty(test.getDescription())) {
      return testRepository.findByDescriptionLike('%' + test.getDescription() + '%');
    }
    if (!Strings.isNullOrEmpty(test.getTitle())) {
      return testRepository.findByTitleLike('%' + test.getTitle() + '%');
    }

    return testRepository.findAll();
  }

  @Override
  public Iterable<Question> findAllQuestions() {
    return questionRepository.findAll();
  }

  @Override
  public Iterable<Test> findAll() {
    return testRepository.findAll();
  }

  @Override
  public Test findOne(Long id) {
    return testRepository.findOne(id);
  }

  public Iterable<Question> questionsDeleteTest(Long idTest, Iterable<Question> questionIterable) {

    if (idTest != null) {
      Test test = testRepository.findOne(idTest);
      if (test != null) {
        Iterable<Question> questionIterable1 = questionService.findByTestsIdLike(test.getId());
        Iterator<Question> questionIterator = questionIterable.iterator();

        for (Question question; questionIterator.hasNext(); ) {
          question = questionIterator.next();
          for (Question question1 : questionIterable1) {
            if (question.getId() == question1.getId()) {
              questionIterator.remove();
            }
          }
        }


      }

      return questionIterable;
    }
    return questionIterable;
  }

  @Override
  public void saveQuestionsOnTest(CollectionFromForm collectionFromForm) {
    //добавить,чтобы проверить есть ли связь с TestRun
    if (collectionFromForm.getIdCol() != null && !containInTestRun(collectionFromForm.getIdCol())) {

      Test test = testRepository.findOne(collectionFromForm.getIdCol());
      SortedSet<Question> questions = new TreeSet<>();
      test.setQuestions(questions);
      testRepository.save(test);
      List<ObjectFromWithID> objectFromWithIDs = collectionFromForm.getObjectFromWithIDs();
      if (objectFromWithIDs != null)
        for (ObjectFromWithID objectFromWithID : objectFromWithIDs) {
          Question question = questionRepository.findOne(objectFromWithID.getId());
          questions.add(question);
        }
      testRepository.save(test);
    }
  }

  @Override
  public Iterable<Test> findAllHaventLine() {
    Iterable<Test> tests = testRepository.findAll();
    Iterator<Test> testIterator = tests.iterator();
    Iterable<TestRun> testRuns = testRunRepository.findAll();
    Iterator<TestRun> testIterator1;
    for (Test test; testIterator.hasNext(); ) {
      test=testIterator.next();
      testIterator1 = testRuns.iterator();
      for (Test test1; testIterator1.hasNext(); ) {
        test1=testIterator1.next().getTest();
        if ( test1!= null &&
                test.getId() == test1.getId()) {
          testIterator.remove();
          continue;
        }
      }
    }
    return tests;
  }

  public Boolean containInTestRun(Long testId) {
    Iterable<TestRun> testRuns = testRunRepository.findAll();
    Iterator<TestRun> testIterator1;
    testIterator1 = testRuns.iterator();
    for (Test test; testIterator1.hasNext(); ) {
      test=testIterator1.next().getTest();
      if (test!=null&&testId == test.getId()) {
        return true;
      }
    }
    return false;
  }
}

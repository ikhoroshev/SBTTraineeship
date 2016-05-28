/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.services;

import javax.annotation.Resource;

import com.google.common.base.Strings;
import org.springframework.stereotype.Service;
import ru.sberbank.model.CollectionFromForm;
import ru.sberbank.model.ObjectFromWithID;
import ru.sberbank.model.Question;
import ru.sberbank.model.Test;
import ru.sberbank.repositories.QuestionRepository;
import ru.sberbank.repositories.TestRepository;

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
      if(collectionFromForm.getIdCol()!=null)
      {

        Test test=testRepository.findOne(collectionFromForm.getIdCol());
        SortedSet<Question> questions = new TreeSet<>();
        List<ObjectFromWithID> objectFromWithIDs=collectionFromForm.getObjectFromWithIDs();
        if(objectFromWithIDs!=null)
        for (ObjectFromWithID objectFromWithID:objectFromWithIDs)
        {
          Question question=questionRepository.findOne(objectFromWithID.getId());
          questions.add(question);
        }
        test.setQuestions(questions);
        // удаляются предыдущие
        testRepository.save(test);
      }
  }

}

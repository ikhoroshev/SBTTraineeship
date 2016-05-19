/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.sberbank.model.Test;

/**
 *
 * @author Raim
 */
public interface TestRepository extends CrudRepository<Test, Long> {
  @Modifying
  @Transactional
  @Query("delete from Test u where u.title = 123")
  void deleteInactiveUsers();

  Iterable<Test> findByTitleLike (String testTitleLike);
  Iterable<Test> findByTitleLikeAndDescriptionLike (String testTitleLike, String testDescriptionLike);
  Iterable<Test> findByDescriptionLike (String testTitleLike);
}

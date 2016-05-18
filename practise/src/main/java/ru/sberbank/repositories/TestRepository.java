/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.Test;

/**
 *
 * @author Raim
 */
public interface TestRepository extends CrudRepository<Test, Long> {
  Iterable<Test> findByTitleLike (String testTitleLike);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.web;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.Test;
import ru.sberbank.services.TestService;

/**
 *
 * @author Raim
 */
@Controller
public class TestController {
  @Resource
  private TestService testService;

  @RequestMapping(value = "/tests/add", method = RequestMethod.GET)
  public String initAddTestForm (Test test){
    return "tests/addTest";
  }

  @RequestMapping(value = "/tests/add", method = RequestMethod.POST)
  public String processAddTestForm (Test test){
    testService.addTest(test);
    return "tests/addTest";
  }




}

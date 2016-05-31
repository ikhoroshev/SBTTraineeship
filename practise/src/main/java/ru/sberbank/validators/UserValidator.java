/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sberbank.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.sberbank.model.User;

/**
 *
 * @author Raim
 */
public class UserValidator implements Validator {

  @Override
  public boolean supports(Class<?> type) {
    return User.class.equals(type);
  }

  @Override
  public void validate(Object o, Errors errors) {
    User user = (User)o;
    if (user.getPassword() != null && !user.getPassword().equals(user.getConfirmPassword())) {
      errors.rejectValue("password", "password");
      errors.rejectValue("confirmPassword", "password");
    }
  }
  
}

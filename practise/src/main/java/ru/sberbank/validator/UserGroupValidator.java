package ru.sberbank.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.sberbank.model.UserGroup;

/**
 * Created by Николай on 20.05.2016.
 */
@Component
public class UserGroupValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserGroup.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","name.empty", "Name is required");

    }
}

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
        UserGroup userGroup = (UserGroup) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","name.empty", "Name is required");

        String name = userGroup.getName();
        if ((name.length()) > 16) {
            errors.rejectValue("name", "name.tooLong", "Name must not more than 16 characters.");
        }

        if (!name.matches("[a-zA-Zа-яА-Я]+")){
            errors.rejectValue("name", "name.tooLetter", "Name can contain only letters.");
        }
    }
}

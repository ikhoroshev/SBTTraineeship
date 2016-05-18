package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.User;

/**
 * Created by Илья on 17.05.2016.
 */
@Controller
public class SearchTestController {
    @RequestMapping(value = "/searchTest", method = RequestMethod.GET)
    public String initSearchForm(User user) {
        return "users/usersList";
    }
}

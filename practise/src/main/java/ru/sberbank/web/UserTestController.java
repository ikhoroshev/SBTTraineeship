package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Николай on 26.05.2016.
 */
@Controller
public class UserTestController {

    @RequestMapping(value = "/userTest/start", method = RequestMethod.GET)
    public String initUserTest(@RequestParam("testId")Long testId,
                               @RequestParam("userId")Long userId){
        System.out.println("" + testId + " " + userId);
        return "userTest/initUserTest";
    }
}

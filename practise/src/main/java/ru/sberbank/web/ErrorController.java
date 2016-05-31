package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Илья on 31.05.2016.
 */
@Controller
public class ErrorController {
    @RequestMapping(value = {"/testRun/404"}, method = RequestMethod.GET)
    public String NotFoudPage() {
        return "ERRORs/404";
    }

    @RequestMapping(value = {"/testRun/403"}, method = RequestMethod.GET)
    public String accessIsDenied() {
        return "ERRORs/403";
    }
}

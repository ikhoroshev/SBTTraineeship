package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.Result;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.UserGroup;
import ru.sberbank.repositories.ResultRepository;
import ru.sberbank.services.ResultService;
import ru.sberbank.services.TestRunService;
import ru.sberbank.services.UserGroupService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Idony on 20.05.2016.
 */
@Controller
public class ResultController {
    @Resource
    private ResultService resultService;
    @Resource
    private UserGroupService userGroupService;

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String initAddUserForm (Model model,Map<String, Object> models){
        Iterable<UserGroup> userGroups = userGroupService.findUsersByExample();
        models.put("listUserGroup", userGroups);
        model.addAttribute("userGroup",new UserGroup());
        return "/result/result";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String processAddUserForm (@ModelAttribute("userGroup")UserGroup userGroup){
        Iterable<Result> results=resultService.findByTestRunUserGroupLike(userGroup);

        return "result/result";
    }

}

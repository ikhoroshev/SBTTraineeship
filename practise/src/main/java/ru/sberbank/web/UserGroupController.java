package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.User;
import ru.sberbank.model.UserGroup;
import ru.sberbank.services.UserGroupService;
import ru.sberbank.services.UserService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Idony on 17.05.2016.
 */
@Controller
public class UserGroupController {
    @Resource
    private UserGroupService userGroupService;

    @RequestMapping(value = "/group/add", method = RequestMethod.GET)
    public String initAddUserForm (UserGroup userGroup){
        return "group/addUserGroup";
    }

    @RequestMapping(value = "/group/add", method = RequestMethod.POST)
    public String processAddUserForm (UserGroup userGroup){
        userGroupService.addUserGroup(userGroup);
        return "group/addUserGroup";
    }
}

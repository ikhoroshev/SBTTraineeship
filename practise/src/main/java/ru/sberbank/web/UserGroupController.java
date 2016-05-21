package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.UserGroup;
import ru.sberbank.model.UserGroupType;
import ru.sberbank.services.UserGroupService;
import ru.sberbank.validator.UserGroupValidator;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
 * Created by Николай on 17.05.2016.
 */
@Controller
public class UserGroupController {

    @Resource
    private UserGroupService userGroupService;

    @RequestMapping(value = "/groups/find", method = RequestMethod.GET)
    public String initGroupList(UserGroup userGroup, Map<String, Object> model){
        Iterable<UserGroup> userGroupIterable = userGroupService.getAllUserGroup();
        model.put("allUserGroup", userGroupIterable);
        return "groups/userGroupList";
    }

    @RequestMapping(value = "/groups/addForm", method = RequestMethod.GET)
    public String initAddForm(UserGroup userGroup, Map<String, Object> model){
        model.put("userGroupType", UserGroupType.values());
        return "groups/addUserGroup";
    }

    @RequestMapping(value = "/groups/add", method = RequestMethod.GET)
    public String processAddUserGroupForm(UserGroup userGroup, BindingResult result, Map<String, Object> model){
        new UserGroupValidator().validate(userGroup, result);
        if (result.hasErrors()){
            return "groups/addUserGroup";
        }
        userGroupService.addUserGroup(userGroup);
        Iterable<UserGroup> userGroupIterable = userGroupService.getAllUserGroup();
        model.put("allUserGroup", userGroupIterable);
        return "groups/userGroupList";
    }

    @RequestMapping(value = "/groups/delete/{userGroupId}", method = RequestMethod.GET)
    public String processAddUserForm (UserGroup userGroup, @PathVariable("userGroupId") long userGroupId){
        userGroupService.deleteUserGroup(userGroupId);
        return "groups/userGroupList";
    }
}

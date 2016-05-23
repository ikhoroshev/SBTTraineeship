package ru.sberbank.web;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/groups/delete", method = RequestMethod.GET)
    public String processAddUserForm (UserGroup userGroup,
                                      @RequestParam("userGroupId") long userGroupId,
                                      Map<String, Object> model){
        try {
            userGroupService.deleteUserGroup(userGroupId);
        }catch (DataIntegrityViolationException e){
            System.out.println(e);
            Iterable<UserGroup> userGroupIterable = userGroupService.getAllUserGroup();
            model.put("allUserGroup", userGroupIterable);
            model.put("noDelete", "- can not be removed");
            model.put("userGroupId", userGroupId);
            return "groups/userGroupList";
        }
        Iterable<UserGroup> userGroupIterable = userGroupService.getAllUserGroup();
        model.put("allUserGroup", userGroupIterable);
        return "groups/userGroupList";
    }
}

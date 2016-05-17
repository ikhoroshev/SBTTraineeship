package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.UserGroup;
import ru.sberbank.model.UserGroupType;
import ru.sberbank.services.UserGroupService;
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
    public String initSearchForm(UserGroup userGroup, Map<String, Object> model){
        model.put("userGroupType", UserGroupType.values());
        return "groups/addUserGroup";
    }

    @RequestMapping(value = "/groups/add", method = RequestMethod.GET)
    public String processAddUserGroupForm(UserGroup userGroup, Map<String, Object> model){
        userGroupService.addUserGroup(userGroup);
        Iterable<UserGroup> userGroupIterable = userGroupService.getAllUserGroup();
        model.put("allUserGroup", userGroupIterable);
        return "groups/userGroupList";
    }

    @RequestMapping(value = "/groups/delete/{userGroupId}", method = RequestMethod.GET)
    public String processAddUserForm (UserGroup userGroup, @PathVariable("userGroupId") long userGroupId){
        userGroupService.deleteUserGroup(userGroupId);
        return "groups/userGroupLis";
    }
}

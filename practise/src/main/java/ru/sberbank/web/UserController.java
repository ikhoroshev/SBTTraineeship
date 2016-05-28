package ru.sberbank.web;

/**
 * Created by salexandrov on 09.05.2016.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.User;
import ru.sberbank.model.UserGroup;
import ru.sberbank.services.UserGroupService;
import ru.sberbank.services.UserService;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private UserGroupService userGroupService;

    @RequestMapping(value = "/users/find", method = RequestMethod.GET)
    public String initSearchForm(User user) {
        return "users/usersList";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String processSearchForm(User user, Map<String, Object> model) {
        Iterable<User> users = userService.findUsersByExample(user);
        model.put("searchResult", users);
        return "users/usersList";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String initAddUserForm (User user,Map<String, Object> model){
        Iterable<UserGroup> userGroups = userGroupService.findUsersByExample();
        model.put("listUserGroup", userGroups);
        return "users/addUser";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String processAddUserForm (@ModelAttribute("user")User user){
        userService.addUser(user);
        return "users/usersList";
    }

    @RequestMapping(value = "/users/delete/{userId}", method = RequestMethod.GET)
    public String processDeleteUserForm (User user, @PathVariable("userId") long userId){
        userService.deleteUser(userId);
        return "users/usersList";
    }

}

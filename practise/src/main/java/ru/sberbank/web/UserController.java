package ru.sberbank.web;

/**
 * Created by salexandrov on 09.05.2016.
 */

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String initSearchForm(User user, Map<String, Object> model) {
        Iterable<User> users = userService.findUsersByExample(user);
        model.put("searchResult", users);
        return "users/usersList";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String processSearchForm(User user, Map<String, Object> model) {
        Iterable<User> users = userService.findUsersByExample(user);
        model.put("searchResult", users);
        return "users/usersList";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String initAddUserForm (User user, Map<String, Object> model){
        Iterable<UserGroup> userGroups = userGroupService.getAllUserGroup();
        model.put("userGroups", userGroups);
        return "users/addUser";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String processAddUserForm (User user, Map<String, Object> model){
        if(user.getGroup() != null) {
            Long groupId = user.getGroup().getId();
            UserGroup userGroup = userGroupService.getUserGroup(groupId);
            user.setGroup(userGroup);
        }
        userService.addUser(user);
        Iterable<User> users = userService.findUsersByExample(user);
        model.put("searchResult", users);
        return "users/usersList";
    }

    @RequestMapping(value = "/users/delete", method = RequestMethod.GET)
    public String processAddUserForm (User user, @RequestParam("userId") long userId, Map<String, Object> model){
        try {
            userService.deleteUser(userId);
        }catch (DataIntegrityViolationException e){
            System.out.println(e);
            Iterable<User> users = userService.findUsersByExample(user);
            model.put("searchResult", users);
            model.put("noDelete", "- can not be removed");
            model.put("userId", userId);
            return "users/usersList";
        }
        Iterable<User> users = userService.findUsersByExample(user);
        model.put("searchResult", users);
        return "users/usersList";
    }

}

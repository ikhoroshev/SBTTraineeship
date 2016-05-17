package ru.sberbank.services;

import ru.sberbank.model.User;
import ru.sberbank.model.UserGroup;

/**
 * Created by Idony on 17.05.2016.
 */
public interface UserGroupService {
    void addUserGroup (UserGroup user);
    void deleteUserGroup (UserGroup userId);
}

package ru.sberbank.services;

import ru.sberbank.model.UserGroup;

/**
 * Created by Николай on 16.05.2016.
 */
public interface UserGroupService {

    void addUserGroup(UserGroup userGroup);
    void deleteUserGroup(Long userGroupId);
}

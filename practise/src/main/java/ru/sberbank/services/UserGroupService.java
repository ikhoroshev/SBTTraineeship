package ru.sberbank.services;

import ru.sberbank.model.UserGroup;

import java.util.List;

/**
 * Created by Николай on 16.05.2016.
 */
public interface UserGroupService {

    void addUserGroup(UserGroup userGroup);
    void deleteUserGroup(Long userGroupId);
    Iterable<UserGroup> getAllUserGroup();
}

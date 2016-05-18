package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.User;
import ru.sberbank.model.UserGroup;
import ru.sberbank.repositories.UserGroupRepository;

import javax.annotation.Resource;

/**
 * Created by Idony on 17.05.2016.
 */
@Service
public class UserGroupServiceImpl implements UserGroupService {
    @Resource
    private UserGroupRepository userGroupRepository;



    public Iterable<UserGroup> findUsersByExample() {
        return userGroupRepository.findAll();
    }

    @Override
    public void addUserGroup(UserGroup userGroup) {
        userGroupRepository.save(userGroup);
    }

    @Override
    public void deleteUserGroup(UserGroup userGroupId) {
        userGroupRepository.delete(userGroupId);
    }
}

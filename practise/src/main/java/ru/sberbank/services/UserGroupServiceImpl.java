package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.UserGroup;
import ru.sberbank.repositories.UserGroupRepository;
import ru.sberbank.repositories.UserRepository;

import javax.annotation.Resource;

/**
 * Created by Idony on 17.05.2016.
 */
@Service
public class UserGroupServiceImpl implements UserGroupService {
    @Resource
    private UserGroupRepository userGroupRepository;

    @Override
    public void addUserGroup(UserGroup userGroup) {
        userGroupRepository.save(userGroup);
    }

    @Override
    public void deleteUserGroup(UserGroup userGroupId) {
        userGroupRepository.delete(userGroupId);
    }
}

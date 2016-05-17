package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.UserGroup;
import ru.sberbank.repositories.UserGroupRepository;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Николай on 16.05.2016.
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
    public void deleteUserGroup(Long userGroupId) {
        userGroupRepository.delete(userGroupId);
    }

    @Override
    public Iterable<UserGroup> getAllUserGroup() {
        return userGroupRepository.findAll();
    }


}

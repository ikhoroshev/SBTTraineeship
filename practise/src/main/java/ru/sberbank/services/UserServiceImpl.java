package ru.sberbank.services;

import com.google.common.base.Strings;
import org.springframework.stereotype.Service;
import ru.sberbank.model.User;
import ru.sberbank.repositories.UserRepository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by salexandrov on 09.05.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Override
    public Iterable<User> findUsersByExample(User user) {
        if (!Strings.isNullOrEmpty(user.getName())
                && !Strings.isNullOrEmpty(user.getGroup().getName())) {
            return userRepository.findByNameAndGroupName(user.getName(), user.getGroup().getName());
        }
        if (!Strings.isNullOrEmpty(user.getName())){
            return userRepository.findByName(user.getName());
        }
        if (user.getGroup() != null && !Strings.isNullOrEmpty(user.getGroup().getName())) {
            return userRepository.findByGroupName(user.getGroup().getName());
        }

        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.delete(userId);
    }
}

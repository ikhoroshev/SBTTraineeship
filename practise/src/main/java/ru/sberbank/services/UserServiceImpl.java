package ru.sberbank.services;

import com.google.common.base.Strings;
import org.hibernate.jpa.criteria.predicate.BooleanExpressionPredicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import ru.sberbank.model.User;
import ru.sberbank.repositories.UserRepository;

import static org.springframework.data.jpa.domain.Specifications.*;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by salexandrov on 09.05.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public User findUserByLogin (String login) {
        if (login != null) {
            return userRepository.findByLogin(login);
        }
        return null;
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        if (login != null && password != null ) {
            return userRepository.findByLoginAndPassword(login, password);
        }
        return null;
    }

    @Override
    public Iterable<User> findUsersByExample(User user) {
        if (user!= null && !Strings.isNullOrEmpty(user.getLastName())
                && !Strings.isNullOrEmpty(user.getGroup().getName())) {
            return userRepository.findByLastNameLikeAndGroupNameLike('%' + user.getLastName() + '%', '%' + user.getGroup().getName() + '%');
        }
        if (user!= null && user.getGroup() != null && !Strings.isNullOrEmpty(user.getLastName())) {
            return userRepository.findByLastNameLike('%' + user.getLastName() + '%');
        }
        if (user!= null && user.getGroup() != null && !Strings.isNullOrEmpty(user.getGroup().getName())) {
            return userRepository.findByGroupNameLike('%' + user.getGroup().getName() + '%');
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

    @Override
    public List<User> findAllByOrderByGroupName() {
        return userRepository.findAllByOrderByGroupName();
    }
}

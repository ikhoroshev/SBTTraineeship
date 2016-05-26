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

/**
 * Created by salexandrov on 09.05.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public Iterable<User> findUsersByExample(User user) {
        if (!Strings.isNullOrEmpty(user.getLastName())
                && !Strings.isNullOrEmpty(user.getGroup().getName())) {
            return userRepository.findByLastNameLikeAndGroupNameLike('%' + user.getLastName() + '%', '%' + user.getGroup().getName() + '%');
        }
        if (!Strings.isNullOrEmpty(user.getLastName())){
            return userRepository.findByLastNameLike('%' + user.getLastName() + '%');
        }
        if (user.getGroup() != null && !Strings.isNullOrEmpty(user.getGroup().getName())) {
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
    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getUser(String username) { return userRepository.findByUsername(username); }

    @Override
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }
}

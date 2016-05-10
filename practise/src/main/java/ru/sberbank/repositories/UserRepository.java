package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.User;

import java.util.List;

/**
 * Created by sbt-shmygin-as on 06.04.2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    Iterable<User> findByNameAndGroupName (String userName, String userGroupName);
    Iterable<User> findByName (String userName);
    Iterable<User> findByGroupName (String userGroupName);
}

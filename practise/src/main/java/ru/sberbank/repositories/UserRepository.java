package ru.sberbank.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.model.User;
import ru.sberbank.model.UserGroup;

import java.util.List;

/**
 * Created by sbt-shmygin-as on 06.04.2016.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Iterable<User> findByLastNameLikeAndGroupNameLike (String userLastNameLike, String userGroupNameLike);
    Iterable<User> findByLastNameLike (String userLastNameLike);
    Iterable<User> findByGroupNameLike (String userGroupNameLike);
    Iterable<User> findByLogin (String login);
    Iterable<User> findByPassword (String password);
    User findByLoginAndPassword (String login, String password);

}

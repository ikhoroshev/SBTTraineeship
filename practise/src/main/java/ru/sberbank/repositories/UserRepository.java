package ru.sberbank.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.User;
import ru.sberbank.model.UserGroupType;

import java.util.List;

/**
 * Created by sbt-shmygin-as on 06.04.2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    Iterable<User> findByLastNameLikeAndGroupNameLike (String userLastNameLike, String userGroupNameLike);
    Iterable<User> findByLastNameLike (String userLastNameLike);
    Iterable<User> findByGroupNameLike (String userGroupNameLike);
    User findByUsername(String username);
    Long countByGroupType(UserGroupType type);
}

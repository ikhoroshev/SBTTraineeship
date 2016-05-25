package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.model.UserGroup;

/**
 * Created by sbt-shmygin-as on 06.04.2016.
 */
@Repository
public interface UserGroupRepository extends CrudRepository<UserGroup, Long> {
}

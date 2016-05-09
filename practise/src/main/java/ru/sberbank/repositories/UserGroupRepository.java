package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.UserGroup;

/**
 * Created by sbt-shmygin-as on 06.04.2016.
 */
public interface UserGroupRepository extends CrudRepository<UserGroup, Long> {
}

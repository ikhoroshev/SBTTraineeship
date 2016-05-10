package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.User;

/**
 * Created by sbt-shmygin-as on 06.04.2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}

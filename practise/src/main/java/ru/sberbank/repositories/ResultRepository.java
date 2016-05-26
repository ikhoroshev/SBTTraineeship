package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.Result;

/**
 * Created by Николай on 26.05.2016.
 */
public interface ResultRepository extends CrudRepository<Result, Long> {
}

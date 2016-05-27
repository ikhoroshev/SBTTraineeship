package ru.sberbank.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sberbank.model.SystemLog;


public interface SystemLogRepository extends CrudRepository<SystemLog, Long>{
    Iterable<SystemLog> findAllByOrderByDateTimeDesc();
    Iterable<SystemLog> findByUserId(Long userId);
}

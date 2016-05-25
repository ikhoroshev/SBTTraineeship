package ru.sberbank.services;

import ru.sberbank.model.SystemLog;

public interface SystemLogService {
    void Log(String message, String... code);
    Iterable<SystemLog> findAll();
}

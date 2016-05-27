package ru.sberbank.services;

import ru.sberbank.model.SystemLog;

public interface SystemLogService {
    void Log(String message,int code);
    void Log(int code);
    Iterable<SystemLog> findAll();
}

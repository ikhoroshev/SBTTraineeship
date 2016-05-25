package ru.sberbank.services;

import org.springframework.stereotype.Service;
import ru.sberbank.model.SystemLog;
import ru.sberbank.repositories.SystemLogRepository;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class SystemLogServiceImpl implements SystemLogService {
    @Resource
    SystemLogRepository logRepository;

    @Override
    public void Log(String message) {
        SystemLog log=new SystemLog();

        log.setMessage(message);
        log.setCode("");
        log.setDateTime(new Date());

        //TODO posle dobavleniya avtorizacii ispravit
        log.setUser(null);

        logRepository.save(log);
    }

    @Override
    public void Log(int code) {
        SystemLog log=new SystemLog();

        log.setMessage(codeToMessage(code));
        log.setCode(String.valueOf(code));
        log.setDateTime(new Date());

        //TODO posle dobavleniya avtorizacii ispravit
        log.setUser(null);

        logRepository.save(log);
    }

    private String codeToMessage(int code){
        switch (code){
            case 10 : return "Был добавлен вопрос";
            case 11 : return "Был изменен вопрос";
            case 12 : return "Был удален вопрос";
            case 13 : return "Была добавлена глава";
            case 14 : return "Была изменена глава";
            case 15 : return "Была удалена глава";
            default: return "";
        }
    }

    @Override
    public Iterable<SystemLog> findAll() { return logRepository.findAll(); }
}

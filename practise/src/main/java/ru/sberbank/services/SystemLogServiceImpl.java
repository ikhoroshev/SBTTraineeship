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
    public void Log(String message, String... code) {
        SystemLog log=new SystemLog();

        log.setMessage(message);
        if (code.length>0)
            log.setCode(code[0]);
        else log.setCode("");

        log.setDateTime(new Date());

        //TODO posle dobavleniya avtorizacii ispravit
        log.setUser(null);

        logRepository.save(log);



    }

    @Override
    public Iterable<SystemLog> findAll() { return logRepository.findAll(); }
}

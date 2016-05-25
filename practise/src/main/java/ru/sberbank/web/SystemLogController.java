package ru.sberbank.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.model.SystemLog;
import ru.sberbank.services.SystemLogService;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class SystemLogController {
    @Resource
    private SystemLogService logService;

    @RequestMapping(value="/log/find", method = RequestMethod.GET)
    public String findLog(Map<String, Object> model){
        Iterable<SystemLog> systemLogs = logService.findAll();
        model.put("systemLogs", systemLogs);
        return "log/viewLog";
    }

}

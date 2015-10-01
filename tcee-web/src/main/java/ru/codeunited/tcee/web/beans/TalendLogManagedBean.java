package ru.codeunited.tcee.web.beans;


import ru.codeunited.Job;
import ru.codeunited.Log;
import ru.codeunited.LogCatcherService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 24.09.15.
 */
@ManagedBean(name = "talendLog")
@SessionScoped
public class TalendLogManagedBean {

    @EJB
    private LogCatcherService logCatcherService;

    private List<Log> logs = new ArrayList<>();

    public int getCount() {
        return logCatcherService.count();
    }

    public List<Log> reloadLog(Job job) {
        logs = logCatcherService.getLogs(job);
        return getLog();
    }

    public List<Log> getLog() {
        return logs;
    }

    public Date getLastDate() {
        return logCatcherService.getLastDate();
    }

}

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
import java.util.Optional;
import static ru.codeunited.tcee.web.beans.Constants.ZERO_TIME;

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

    private Date lastDate = null;

    public int getCount() {
        return getLog().size();
    }

    public List<Log> reloadLog(Job job) {
        logs = logCatcherService.getLogs(job);
        lastDate = ZERO_TIME;
        logs.stream().max(Log::compareTo).ifPresent(log -> lastDate = log.getMoment());
        return getLog();
    }

    public List<Log> getLog() {
        return logs;
    }

    public Date getLastDate() {
        return lastDate;
    }

}

package ru.codeunited.tcee.web.beans;


import org.primefaces.model.LazyDataModel;
import ru.codeunited.api.Job;
import ru.codeunited.api.JobRun;
import ru.codeunited.api.Log;
import ru.codeunited.api.LogCatcherService;
import ru.codeunited.tcee.web.beans.models.LazyLogDataModel;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    // log for selected job
    private List<Log> logs = new ArrayList<>();

    private LazyDataModel<Log> lazyLog = LazyLogDataModel.EMPTY;

    private Date lastDate = null;

    public int getCount() {
        return getLog().size();
    }

    /**
     * Update inforamtion about log in a currently viewed job.
     * @param job
     * @return
     */
    public List<Log> reloadLog(Job job) {
        logs = logCatcherService.getLogs(job);
        lazyLog = new LazyLogDataModel(getLog());
        resetLastMoment();
        return getLog();
    }

    public List<Log> reloadLog(JobRun jobRun) {
        logs = logCatcherService.getLogs(jobRun);
        lazyLog = new LazyLogDataModel(getLog());
        resetLastMoment();
        return getLog();
    }

    private void resetLastMoment() {
        lastDate = ZERO_TIME;
        logs.stream().max(Log::compareTo).ifPresent(log -> lastDate = log.getMoment());
    }

    /**
     * Get currently loaded log info.
     * @return
     */
    public List<Log> getLog() {
        return logs;
    }

    public LazyDataModel<Log> getLazyLog() {
        return lazyLog;
    }

    public Date getLastDate() {
        return lastDate;
    }

}

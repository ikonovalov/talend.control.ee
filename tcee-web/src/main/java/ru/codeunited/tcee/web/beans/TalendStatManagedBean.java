package ru.codeunited.tcee.web.beans;

import ru.codeunited.Job;
import ru.codeunited.JobRun;
import ru.codeunited.JobService;
import ru.codeunited.StatisticCatcherService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 25.09.15.
 */
@ManagedBean(name = "talendStat")
@SessionScoped
public class TalendStatManagedBean {

    @EJB
    private StatisticCatcherService statCatcherService;

    @EJB
    private JobService jobService;

    private List<JobRun> jobRuns;

    public List<JobRun> reloadJobRuns(Job job) {
        jobRuns = statCatcherService.runsForJob(job);
        return jobRuns;
    }

    public int getJobRunsCount() {
        return jobRuns != null ? jobRuns.size() : 0;
    }

    public List<JobRun> getJobRuns() {
        return jobRuns;
    }

}

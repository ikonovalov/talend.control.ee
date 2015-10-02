package ru.codeunited.tcee.web.beans;

import org.primefaces.model.LazyDataModel;
import ru.codeunited.Job;
import ru.codeunited.JobRun;
import ru.codeunited.JobService;
import ru.codeunited.StatisticCatcherService;
import ru.codeunited.tcee.web.beans.models.LazyJobRunDataModel;

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

    private LazyDataModel<JobRun> lazyJobRuns = LazyJobRunDataModel.EMPTY;

    public List<JobRun> reloadJobRuns(Job job) {
        jobRuns = statCatcherService.runsForJob(job);
        lazyJobRuns = new LazyJobRunDataModel(jobRuns);
        return jobRuns;
    }

    public int getJobRunsCount() {
        return jobRuns != null ? jobRuns.size() : 0;
    }

    public List<JobRun> getJobRuns() {
        return jobRuns;
    }

    public LazyDataModel<JobRun> getLazyJobRuns() {
        return lazyJobRuns;
    }

    public JobRun findJobRunForPID(String pid) {
        return jobRuns.stream().filter(run -> run.getStart().getPid().equals(pid)).findFirst().orElse(null);
    }

}

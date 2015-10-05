package ru.codeunited.tcee.rs;

import ru.codeunited.api.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 05.10.15.
 */
@Path("/project/{project}/{job}")
@Stateless
public class JobResource {

    @EJB
    private JobService jobService;

    @EJB
    private StatisticCatcherService statisticService;

    @EJB
    private LogCatcherService logService;

    @GET
    @Path("/")
    @Produces("application/json")
    public Job getJob(@PathParam("project") String projectName, @PathParam("job") String jobName) {
        return Optional.ofNullable(jobService.getJob(projectName, jobName)).orElse(null);
    }

    @GET
    @Path("runs")
    @Produces("application/json")
    public List<JobRun> getJobRuns(@PathParam("project") String projectName, @PathParam("job") String jobName) {
        List<JobRun> jobRuns = new ArrayList<>();
        Optional<Job> job = Optional.ofNullable(jobService.getJob(projectName, jobName));
        job.ifPresent(j -> jobRuns.addAll(statisticService.runsForJob(j)));
        return jobRuns;
    }

    @GET
    @Path("logs")
    @Produces("application/json")
    public List<Log> getLog(@PathParam("project") String projectName, @PathParam("job") String jobName) {
        List<Log> jobRuns = new ArrayList<>();
        Optional
                .ofNullable(jobService.getJob(projectName, jobName))
                .ifPresent(j -> jobRuns.addAll(logService.getLogs(j)));
        return jobRuns;
    }

}

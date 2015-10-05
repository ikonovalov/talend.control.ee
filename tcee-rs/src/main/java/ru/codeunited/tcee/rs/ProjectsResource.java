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
@Path("/project")
@Stateless
public class ProjectsResource {

    @EJB
    private JobService jobService;

    @GET
    @Path("/")
    @Produces("application/json" )
    public List<Project> getProjectsList() {
        return jobService.getProjects();
    }

    @GET
    @Path("{project}")
    @Produces("application/json") /* exit to job level */
    public List<Job> getJobsInProject(@PathParam("project") String projectName) {
        final List<Job> jobList = new ArrayList<>();
        Optional
                .ofNullable(jobService.getProject(projectName))
                .ifPresent(
                        project -> jobList.addAll(jobService.getJobs(project))
                );
        return jobList;
    }

}

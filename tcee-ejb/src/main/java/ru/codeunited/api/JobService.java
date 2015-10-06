package ru.codeunited.api;

import javax.ejb.Remote;
import javax.validation.Valid;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 29.09.15.
 */
@Remote
public interface JobService {

    /**
     * Returns all jobs for project
     * @param project
     * @return
     */
    List<Job> getJobs(@Valid Project project);

    /**
     * Returns all jobs for project ("by project name")
     * @param project list
     * @return
     */
    List<Job> getJobs(String project);

    /**
     * Show all registered job.
     * @return
     */
    List<Project> getProjects();

    /**
     * Find Project for name.
     * @param projectName
     * @return
     */
    Project getProject(String projectName);

    /**
     * Find Job for project and job names.
     * @param project
     * @param job
     * @return
     */
    Job getJob(String project, String job);
}

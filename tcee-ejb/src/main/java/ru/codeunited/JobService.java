package ru.codeunited;

import javax.ejb.Remote;
import java.util.List;
import java.util.Set;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 29.09.15.
 */
@Remote
public interface JobService {

    List<Job> getJobs();

    List<Job> getJobs(Project project);

    List<Project> getProjects();

}
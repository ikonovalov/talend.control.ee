package ru.codeunited.api;

import javax.ejb.Remote;
import java.util.List;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 29.09.15.
 */
@Remote
public interface JobService {

    List<Job> getJobs(Project project);

    List<Project> getProjects();

}
